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
// ��ȡ�ļ��Ĵ�С
long GetFileLength(string strPath)
{
    ifstream fin(strPath.c_str(), ios::in | ios::binary);
    fin.seekg(0, ios_base::end);
    streampos pos = fin.tellg();//���ص�ǰ�ļ�λ��,���ڶ�ȡ�ļ�����
    long lenSize = static_cast<long>(pos);
    fin.close();
    cout<<"content��"<<lenSize<<endl;
    return lenSize;
}
int main(int argc, char **argv)
{
    // ���岢�ҳ�ʼ��һ���������׽���
    sockaddr_in addrServer;
    addrServer.sin_family = AF_INET;
    addrServer.sin_addr.S_un.S_addr = INADDR_ANY;
    addrServer.sin_port = htons(PORT);
    // ��ʼ��
    WSADATA wsaData;
    WORD socketVersion = MAKEWORD(2, 2);
    if (WSAStartup(socketVersion, &wsaData) != 0)
    {
        cout<<"��ʼ��ʧ��!"<<endl;
        exit(1);
    }
    cout<<"��ʼ���ɹ�!"<<endl;
    // �����׽���
    SOCKET socketServer = socket(AF_INET, SOCK_STREAM, 0);
    if (socketServer == SOCKET_ERROR)
    {
        cout<<"����ʧ��!"<<endl;
        exit(1);
    }
    cout<<"�����ɹ�!"<<endl;
    // �󶨷������׽���
    if (bind(socketServer, (LPSOCKADDR)&addrServer, sizeof(addrServer)) == SOCKET_ERROR)
    {
        cout<<"��ʧ��!"<<endl;
        exit(1);
    }
    cout<<"�󶨳ɹ�!"<<endl;
    // ����
    if (listen(socketServer, 10) ==  SOCKET_ERROR)
    {
        cout<<"����ʧ��!"<<endl;
        exit(1);
    }
    while (true)
    {
        cout<<"Listening ... "<<endl;
        sockaddr_in addrClient;
        int nClientAddrLen = sizeof(addrClient);
        //�������˽�������
        SOCKET socketClient = accept(socketServer, (sockaddr*)&addrClient, &nClientAddrLen);
        if (SOCKET_ERROR == socketClient)
        {
            cout<<"����ʧ��!"<<endl;
            break;
        }
        char buffer[BUFFER_SIZE];
        memset(buffer, 0, BUFFER_SIZE);
        //��������
        if (recv(socketClient, buffer, BUFFER_SIZE, 0) < 0)
        {
            cout<<"��������ʧ��!"<<endl;
            break;
        }
        cout<<"���յ������� : "<<endl<<buffer;
        // response
        // send header
        memset(buffer, 0, BUFFER_SIZE);
        sprintf(buffer, HEADER, GetFileLength(strPath));//���ļ���ͷ�ļ��ϲ�Ȼ��������
        if (send(socketClient, buffer, strlen(buffer), 0) < 0)
        {
            cout<<"��������ʧ��!"<<endl;
            break;
        }
        //��ȡ�ı�
        ifstream fin(strPath.c_str(), ios::in | ios::binary);//��ȡ�ļ�����
        if (fin.is_open())
        {
            memset(buffer, 0, BUFFER_SIZE);
            //ÿ�ζ�ȡһ���ֽ�
            while (fin.read(buffer, BUFFER_SIZE - 1))
            {
                if (send(socketClient, buffer, strlen(buffer), 0) < 0)
                {
                    cout<<"��������ʧ��!"<<endl;
                    break;
                }
                memset(buffer, 0, BUFFER_SIZE);
            }
            if (send(socketClient, buffer, strlen(buffer), 0) < 0)
            {
                cout<<"��������ʧ��!"<<endl;
                break;
            }
        }
        //�رգ�����
        fin.close();
        closesocket(socketClient);
    }
    closesocket(socketServer);
    WSACleanup();
    return 0;
}
