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
     //WSAStarup����WSA(Windows SocKNDs Asynchronous��Windows�׽����첽)����������
     int err = WSAStartup(wVersionRequested, &wsaData);
     cout << "WSAStartup:" << err << endl;
     SOCKET sockClient; //�ͻ��˵��׽���
     sockClient = socket(AF_INET, SOCK_STREAM, 0); //����socket����

     HOSTENT* pHostent;//hostent��host entry����д���ýṹ��¼��������Ϣ����������������������ַ���͡���ַ���Ⱥ͵�ַ�б�

     pHostent = gethostbyname("smtp.qq.com"); //�õ��й�����������Ϣ,���ӵ�qq���������

     SOCKADDR_IN addrServer; //����˵�ַ
     addrServer.sin_addr.S_un.S_addr = *((DWORD *)pHostent->h_addr_list[0]); //�õ�smtp�������������ֽ����ip��ַ
     addrServer.sin_family = AF_INET;
     addrServer.sin_port = htons(25); //���Ӷ˿�25
     //int connect (SOCKET s , const struct sockaddr FAR *name , int namelen ); //����ԭ��
     err = connect(sockClient, (SOCKADDR*)&addrServer, sizeof(SOCKADDR)); //���������������
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
     static string uername = "MTQzMzM5ODA0MEBxcS5jb20=\r\n";//�˴���base64���ܵ�����
     send(sockClient, uername.c_str(), uername.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "usrname:" << buff << endl;
     static string psw = "cnpicXRuaGVvcXBjZmhiaQ==\r\n";//�˴���base64���ܵ���Ȩ��
     send(sockClient, psw.c_str(), psw.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "password:" << buff << endl;
     string mail;
     cout << "�����ռ������䣺";
     cin >> mail;
     message = "MAIL FROM:<1433398040@qq.com> \r\nRCPT TO:<";//�˴����Լ������ַ
     message.append(mail);
     message.append("> \r\n");
     cout << "message=" << message;
     send(sockClient, message.c_str(), message.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "mail from��״̬��: " << buff << endl;
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout << "rcpt to��״̬��: " << buff << endl;
     message = "DATA\r\n";
     send(sockClient, message.c_str(), message.length(), 0);
     buff[recv(sockClient, buff, 1500, 0)] = '\0';
     cout<< "data����ص�״̬��: " << buff << endl;

     static string form= "from:<1433398040@qq.com>\r\nto:<"+mail+">\r\nsubject:";//���Լ������ַ

        cout<<"���⣺";
        cin>>subject;
        form.append(subject);
        form.append("\r\n\r\n");
        cout<<"���ݣ�";
        cin>>info;
        form.append(info);
        form.append("\r\n.\r\n");
        send(sockClient, form.c_str(), form.length(), 0);
        message = "quit\r\n";
         send(sockClient, message.c_str(), message.length(), 0);
        buff[recv(sockClient, buff, 1500, 0)] = '\0';
         cout << "����״̬�룺" << buff << endl;

         cout << "���ͳɹ���"<<endl;
     system("pause");
}

