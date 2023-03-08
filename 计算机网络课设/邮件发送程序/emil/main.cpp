#include <iostream>
#include <string>
#include <WinSock2.h>
using namespace std;
#pragma comment(lib, "ws2_32.lib")

int main()
{
     char buff[1500];
     string message;
     string info;
     string subject;

     WSADATA wsaData;
     WORD wVersionRequested = MAKEWORD(2, 2);
     //WSAStarup，即WSA(Windows SocKNDs Asynchronous，Windows套接字异步)的启动命令
     int err = WSAStartup(wVersionRequested, &wsaData);
     cout << "WSAStartup:" << err << endl;
     SOCKET sockClient; //客户端的套接字
     sockClient = socket(AF_INET, SOCK_STREAM, 0); //建立socket对象

     HOSTENT* pHostent;//hostent是host entry的缩写，该结构记录主机的信息，包括主机名、别名、地址类型、地址长度和地址列表

     pHostent = gethostbyname("smtp.qq.com"); //得到有关于域名的信息,链接到qq邮箱服务器

     SOCKADDR_IN addrServer; //服务端地址
     addrServer.sin_addr.S_un.S_addr = *((DWORD *)pHostent->h_addr_list[0]); //得到smtp服务器的网络字节序的ip地址
     addrServer.sin_family = AF_INET;
     addrServer.sin_port = htons(25); //连接端口25
     //int connect (SOCKET s , const struct sockaddr FAR *name , int namelen ); //函数原型
     err = connect(sockClient, (SOCKADDR*)&addrServer, sizeof(SOCKADDR)); //向服务器发送请求
     cout << "connect:" << err << endl;
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "connect:" << buff << endl;
     string ehlo = "ehlo 1433398040@qq.com\r\n";
     send(sockClient, ehlo.c_str(), ehlo.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout <<"ehlo:"  << buff << endl;
     static string path = "auth login\r\n";
     send(sockClient, path.c_str(), path.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "auth login:" << buff << endl;
     static string uername = "MTQzMzM5ODA0MEBxcS5jb20=\r\n";//此处填base64加密的邮箱
     send(sockClient, uername.c_str(), uername.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "usrname:" << buff << endl;
     static string psw = "cnpicXRuaGVvcXBjZmhiaQ==\r\n";//此处填base64加密的授权码
     send(sockClient, psw.c_str(), psw.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "password:" << buff << endl;
     string mail;
     cout << "输入收件人邮箱：";
     cin >> mail;
     message = "MAIL FROM:<1433398040@qq.com> \r\nRCPT TO:<";//此处填自己邮箱地址
     message.append(mail);
     message.append("> \r\n");
     cout << "message=" << message;
     send(sockClient, message.c_str(), message.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "mail from的状态码: " << buff << endl;
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "rcpt to的状态码: " << buff << endl;
     message = "DATA\r\n";
     send(sockClient, message.c_str(), message.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout<< "data命令返回的状态码: " << buff << endl;

     static string form= "from:<1433398040@qq.com>\r\nto:<"+mail+">\r\nsubject:";//填自己邮箱地址

        cout<<"主题：";
        cin>>subject;
        form.append(subject);
        form.append("\r\n\r\n");
        cout<<"内容：";
        cin>>info;
        form.append(info);
        form.append("\r\n.\r\n");
        send(sockClient, form.c_str(), form.length(), 0);
        message = "quit\r\n";
         send(sockClient, message.c_str(), message.length(), 0);
        buff[recv(sockClient, buff, 1500, 0)] = '\0';
         cout << "返回状态码：" << buff << endl;

         cout << "发送成功！"<<endl;
     system("pause");
}

