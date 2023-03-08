#include<stdio.h>
#include<windows.h>
#include<WinSock2.h>
#pragma comment(lib,"ws2_32.lib")
#include<bits/stdc++.h>
using namespace std;
SOCKADDR_IN cAddr={0};
int len = sizeof cAddr;
SOCKET clientSocket[1024];
int countf=0;
void tongxing(int idx)
{
    char buff[1024];
    int r;
    while(1)
    {
        r=recv(clientSocket[idx],buff,1023,NULL);
         if(r>0){
                buff[r]=0;
            cout<<idx<<">>"<<buff<<endl;
            //广播数据
            for(int i=0;i<countf;i++)
            {
                send(clientSocket[i],buff,strlen(buff),NULL);
            }

        }

    }
}
int main()
{
    //1.请求协议版本
    WSADATA wsaData;
    WSAStartup(MAKEWORD(2,2),&wsaData);
    if(LOBYTE(wsaData.wVersion)!=2||HIBYTE(wsaData.wVersion)!=2)
    {
        cout<<"请求协议版本失败！"<<endl;
        return -1;
    }
    cout<<"请求协议成功!"<<endl;

    //2.创建socket
    SOCKET serverSocket = socket(AF_INET,SOCK_STREAM,IPPROTO_TCP);
    if(SOCKET_ERROR== serverSocket )
    {
        cout<<"创建SOCKET失败! "<<endl;
        return -2;
    }
    cout<<"创建socket成功!"<<endl;
    //3.创建协议地址族
    SOCKADDR_IN addr={0};
    addr.sin_family=AF_INET;//协议版本
    addr.sin_addr.S_un.S_addr=inet_addr("192.168.199.203");
    addr.sin_port=htons(10278); //0-65535  10000左右

    //4.绑定
    int r=bind(serverSocket,(sockaddr*)&addr,sizeof addr);
    if(r==-1)
    {
        cout<<"bind失败！"<<endl;
        closesocket(serverSocket);
        WSACleanup();
        return -3;
    }
    cout<<"bind成功！"<<endl;
    //5.监听
    r=listen(serverSocket,10);
    if(r==-1)
    {
        cout<<"listen失败！"<<endl;
        closesocket(serverSocket);
        WSACleanup();
        return -4;
    }
    cout<<"listen成功！"<<endl;
    //6.等待客户端连接
    //客户端协议地址族
    while(1)
    {
       clientSocket[countf]=accept(serverSocket,(sockaddr*)&cAddr,&len);
        if(SOCKET_ERROR == clientSocket[countf]){
            cout<<"服务器宕机了！"<<endl;
            closesocket(serverSocket);
            WSACleanup();
            return -5;
        }
        cout<<"客户端连接到服务器了:";
        cout<<inet_ntoa(cAddr.sin_addr);
        cout<<"！"<<endl;

        CreateThread(NULL,NULL,(LPTHREAD_START_ROUTINE)tongxing,
                    (char*)countf,NULL,NULL);
        countf++;
    }

    //7.通信
    /*char buff[1024];
    while(1)
    {
        r=recv(clientSocket,buff,1023,NULL);
        if(r>0){
                buff[r]=0;
        cout<<">>"<<buff<<endl;

        }
    }*/
    return 0;
}
