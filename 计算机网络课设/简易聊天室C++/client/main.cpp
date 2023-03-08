#include<stdio.h>
#include<windows.h>
#include<graphics.h>
#include<WinSock2.h>
#pragma comment(lib,"ws2_32.lib")
#include<bits/stdc++.h>
#include<iostream>
using namespace std;
 SOCKET clientSocket;
 HWND hWnd;
 int countf=0;
 void jieshou()
 {
     char recvBuff[1024];
     int r;
     while(1)
     {
         r=recv(clientSocket,recvBuff,1023,NULL);
         if(r>0)
         {
            recvBuff[r]=0;
        //    outtextxy(0,countf*20,recvBuff);
            countf++;
         }
     }
 }
int main()
{
    //初始化界面
   // initgraph(300,400,SHOWCONSOLE);

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
    clientSocket = socket(AF_INET,SOCK_STREAM,IPPROTO_TCP);
    if(SOCKET_ERROR== clientSocket )
    {
        cout<<"创建SOCKET失败! "<<endl;
        return -2;
    }
    cout<<"创建socket成功!"<<endl;
    //3.获取服务器协议地址族
    SOCKADDR_IN addr={0};
    addr.sin_family=AF_INET;//协议版本
    addr.sin_addr.S_un.S_addr=inet_addr("192.168.199.203");
    addr.sin_port=htons(10278); //0-65535  10000左右

    //4.连接服务器
    int r=connect(clientSocket,(sockaddr*)&addr,sizeof addr);
    if(r==-1)
    {
        cout<<"连接服务器失败！"<<endl;
        return -3;
    }
    cout<<"连接服务器成功！"<<endl;
    //5.通信
   char buff[1024];
    CreateThread(NULL,NULL,
                 (LPTHREAD_START_ROUTINE)jieshou,
                 NULL,NULL,NULL);
    while(1){
        cout<<"聊天内容："<<endl;
        cin>>buff;
        send(clientSocket,buff,strlen(buff),NULL);
    }
    return 0;

}

