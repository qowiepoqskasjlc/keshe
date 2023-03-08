#include <cstdio>
#include <string>
#include <fstream>
#include <WinSock2.h>
#include <iostream>
using namespace std;
#define BUFFER_SIZE 1024
#define HOST "192.168.199.203"
#define PORT 9100
#define HEADER "\
HTTP/1.1 200 OK\r\n\
Content-Type: text/html; charset=UTF-8\r\n\
Server: ZYhttp_v1.0.1\r\n\
Content-Length: %ld\r\n\r\n\
"
const string strPath = "/Users/34417_94e1pvj/Desktop/jwks/keshe8/webserver/bin/Debug/aaa.html";
#pragma comment(lib, "WS2_32")
// 获取文件的大小
long GetFileLength(string strPath)
{
    ifstream fin(strPath.c_str(), ios::in | ios::binary);
    fin.seekg(0, ios_base::end);
    streampos pos = fin.tellg();//返回当前文件位置,用于读取文件长度
    long lenSize = static_cast<long>(pos);
    fin.close();
    cout<<"content："<<lenSize<<endl;
    return lenSize;
}
int main(int argc, char **argv)
{
    // 定义并且初始化一个服务器套接字
    sockaddr_in addrServer;
    addrServer.sin_family = AF_INET;
    addrServer.sin_addr.S_un.S_addr = INADDR_ANY;
    addrServer.sin_port = htons(PORT);
    // 初始化
    WSADATA wsaData;
    WORD socketVersion = MAKEWORD(2, 2);
    if (WSAStartup(socketVersion, &wsaData) != 0)
    {
        cout<<"初始化失败!"<<endl;
        exit(1);
    }
    cout<<"初始化成功!"<<endl;
    // 创建套接字
    SOCKET socketServer = socket(AF_INET, SOCK_STREAM, 0);
    if (socketServer == SOCKET_ERROR)
    {
        cout<<"创建失败!"<<endl;
        exit(1);
    }
    cout<<"创建成功!"<<endl;
    // 绑定服务器套接字
    if (bind(socketServer, (LPSOCKADDR)&addrServer, sizeof(addrServer)) == SOCKET_ERROR)
    {
        cout<<"绑定失败!"<<endl;
        exit(1);
    }
    cout<<"绑定成功!"<<endl;
    // 监听
    if (listen(socketServer, 10) ==  SOCKET_ERROR)
    {
        cout<<"监听失败!"<<endl;
        exit(1);
    }
    while (true)
    {
        cout<<"Listening ... "<<endl;
        sockaddr_in addrClient;
        int nClientAddrLen = sizeof(addrClient);
        //服务器端建立连接
        SOCKET socketClient = accept(socketServer, (sockaddr*)&addrClient, &nClientAddrLen);
        if (SOCKET_ERROR == socketClient)
        {
            cout<<"接收失败!"<<endl;
            break;
        }
        char buffer[BUFFER_SIZE];
        memset(buffer, 0, BUFFER_SIZE);
        //接收数据
        if (recv(socketClient, buffer, BUFFER_SIZE, 0) < 0)
        {
            cout<<"接收数据失败!"<<endl;
            break;
        }
        cout<<"接收到的数据 : "<<endl<<buffer;
        // response
        // send header
        memset(buffer, 0, BUFFER_SIZE);
        sprintf(buffer, HEADER, GetFileLength(strPath));//把文件和头文件合并然后发送数据
        if (send(socketClient, buffer, strlen(buffer), 0) < 0)
        {
            cout<<"发送数据失败!"<<endl;
            break;
        }
        //读取文本
        ifstream fin(strPath.c_str(), ios::in | ios::binary);//读取文件长度
        if (fin.is_open())
        {
            memset(buffer, 0, BUFFER_SIZE);
            //每次读取一个字节
            while (fin.read(buffer, BUFFER_SIZE - 1))
            {
                if (send(socketClient, buffer, strlen(buffer), 0) < 0)
                {
                    cout<<"发送数据失败!"<<endl;
                    break;
                }
                memset(buffer, 0, BUFFER_SIZE);
            }
            if (send(socketClient, buffer, strlen(buffer), 0) < 0)
            {
                cout<<"发送数据失败!"<<endl;
                break;
            }
        }
        //关闭，结束
        fin.close();
        closesocket(socketClient);
    }
    closesocket(socketServer);
    WSACleanup();
    return 0;
}
