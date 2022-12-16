#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

#define USER_FILE "data.bin1"
int geshu=0;
typedef struct xinxi     /*定义结构体类型,存储用户信息*/
{
    char xuehao[50];
    char yonghuming[50];
    char nicheng[50];
    char pw[50];
    double yue;

    int hongbao;
    struct xinxi *next;
} x;

void vPutList(x *head);
void vOutputList(x **head);
void vWrite_data(x *info);
int iIs_Account_Exist(char *name,x *info);
int iIs_Effective_Password(char *password,char *password0) ;
int iIs_Effective_Name(char *name);
void vRegisterPw();
void vInput_password(char *password0);
int iLogin_Password();
void iMainMenu();
int menu_select();
x *create();
void print(x *h);
void hongbao(int n,double all);
double qiang(x *h,int n,double *q);
void fa(x *h);
void search(x *h);
x  *insert(x *h);
x *delete1(x *h);
void save(x *h);
x *load();
void ling(x *h);
void denglu();
void vPutList(x *head)//将数据全部存入文件里
{
    FILE *fp;
    fp = fopen("D:\\data.txt","w"); //输入想保存的路径
        while (head)
    {
        fwrite(head, sizeof(x), 1, fp);
        head = head->next;
    }
}
 void vOutputList(x **head)
{
    FILE *fp;
    x *p=NULL,*q;
    fp=fopen("D:\\data.txt", "r");
    if(!fp)
    printf("读取数据失败，该文件不存在"),getchar(),exit(0);
    p=(x*)malloc(sizeof(x));
    fread(p,sizeof(x),1,fp);
    while(!feof(fp))
    {
        if(*head==NULL)
        *head=p;
        else
        q->next=p;
        q=p;
        p=(x*)malloc(sizeof(x));
     }
     if(p)
     p->next=NULL;
     fclose(fp);
}
 void vWrite_data(x *info)
{
     unsigned char len;
     FILE *fp=NULL;
     fp = fopen(USER_FILE, "a");
     if(fp == NULL)
     {
          printf("can not open file \n");
          return;
     }
     len = strlen(info->yonghuming);
     fwrite(&len, 1, 1, fp);
     fwrite(info->yonghuming, 1, len, fp);
     len = strlen(info->pw);
     fwrite(&len, 1, 1, fp);
     fwrite(info->pw, 1, len, fp);
     fclose(fp);
}
 int iIs_Account_Exist(char *name,x *info)//判断输入的账号是否被注册过
{   FILE *fp=NULL;
    unsigned char len;
    fp = fopen(USER_FILE, "r");
    if (!fp) return 0;
    while(!feof(fp))
    {
     memset(info, 0, sizeof *info);
     fread(&len, 1, 1, fp);
     fread(info->yonghuming, 1, len, fp);
     fread(&len, 1, 1, fp);
     fread(info->pw, 1, len, fp);
     if (!strcmp(info->yonghuming,name)) return 1;
    }
    fclose(fp);
    return   0;
}
int iIs_Effective_Password(char *password,char *password0)   //此函数用于验证密码
{

            if(!strcmp(password0,password))
                  return 1;
            else
                  return 0;

}
int iIs_Effective_Name(char *name) //判断账号的有效性
{
    if(name[0]>='a'&&name[0]<='z'||name[0]>='0'&&name[0]<='9'||name[0]>='A'&&name[0]<='Z')
    return 1;
    else
    return 0;
 }
 void vRegisterPw()//注册账号和密码
{   x info;
    char name[20]={0},pw[50]={0};
    printf("请输入账号(输入英文字符):   ");
    scanf("%s",name);
    while(!iIs_Effective_Name(name))
    {
        printf("该账号不符合规定，请重新输入账号:    ");
        scanf("%s",name);
    }
    while(iIs_Account_Exist(name,&info))
    {   printf("该账号已被注册，请重新输入账号:   ");
        scanf("%s",name);
    }
    strcpy(info.yonghuming,name);
    while(printf("请输入密码(少于6位字符):   "),scanf("%s",info.pw),printf("请再输入一次: "),scanf("%s",pw), !iIs_Effective_Password(info.pw,pw))
    printf("\n两次密码不一致，请重新录入！！！\n");
    vWrite_data(&info);
}
void vInput_password(char *password0)//输入密码，密码支持6位的字符
{
            char ch;
            int i=0;
            while((ch=getch())!='\r' && i<=6)
            {
                if(ch=='\b')
                {
                    if(i>0)
                    {
                        i--;
                        printf("\b \b");// 密码支持退格的实现
                    }
                }
                else if(!(ch<='9' && ch>='0'))//限制输入的密码只能是数字
                {
                    if(i>0)
                    {
                        i--;
                    }
                 }
                 else
                {
                    password0[i++]=ch;//登录时密码以*形式显示
                    printf("*");
                }
            }
            password0[i]='\0';
}

int iLogin_Password()//登录
{
    char name[20]={0},pw[50]={0};
    int f=0;
    int a;
    x info,*h=NULL;
     for(;;)
    {
      printf("请输入账号:   ");
      scanf("%s",name);
      printf("请输入密码:   ");
      vInput_password(pw);
            if  (!iIs_Effective_Name(name) || !iIs_Account_Exist(name,&info) || !iIs_Effective_Password(info.pw,pw) )
            {
                printf("\n用户名或密码错误\n");
                printf("请选择1.注册\n      2.再次输入密码\n");
                scanf("%d",&a);
                if(a==1)
                {
                    vRegisterPw();printf("\n注册成功,跳转到登录页面:\n");system("CLS");
                }
            }
            else
            {printf("\n欢迎使用\n");system("CLS");denglu(); return 1;}
    }
     return 0;
}
void iMainMenu()    //该函数用于输出主主主主界面
{
       system("cls");//实现清屏
       printf("-----------------------\n");
       printf("   请选择操作的方式:\n");
       printf("   1.注册\n");
       printf("   2.登录\n");
       printf("   3.退出\n");
       printf("请输入您的选项:");
       int m;
       while(fflush(stdin),!scanf("%d",&m) || m<1 || m>3)//排除输入错误的情况，fflush(stdin)清空输入缓冲区
    {
        printf("   输入序号有误,请重新输入: ");

    }
    switch(m)
         {
           case 1:
             vRegisterPw();printf("\n注册成功,跳转到登录页面:\n");system("CLS");          //注册
           case 2:
             if (!iLogin_Password()) return; break;            //登录
           case 3:
             exit(0);                      //退出
         }
}

/*菜单函数，返回值为整数，待修改*/
int menu_select()
{
    char s[3];
    int c;
    printf("\n         ***************主菜单************\n");
    printf("             1. 输入用户信息\n");
    printf("             2. 显示用户信息\n");
    printf("             3. 发红包\n");
    printf("             4. 抢红包\n");
    printf("             5. 查找记录\n");
    printf("             6. 插入用户信息\n");
    printf("             7. 删除用户信息\n");
    printf("             8. 将所有信息保存到文件\n");
    printf("             9. 从文件中读入所有记录\n");
    printf("             10. 余额查询\n");
    printf("             11. 退出\n");
    printf("         ***********************************\n\n");
    do
    {
        printf("         请选择操作(1-11):");
        scanf("%s",s);
        c=atoi(s);
    }while(c<0||c>11); /*选择项不在0~9之间重输*/
    return(c); /*返回选择项，主程序根据该数调用相应的函数*/
}

/*创建链表，完成数据录入功能，新结点在表头插入*/
x *create(x *h)
{
    int i;
    double s;
    x *info;             /*h:头结点指针；info:新结点指针*/
    for(;;)
    {
        info=(x *)malloc(sizeof(x));  /*申请空间*/
        if(!info)                                 /*如果指针info为空*/
        {
             printf("\n内存分配失败");
             return NULL;                         /*返回空指针*/
        }
        printf("\n请按如下提示输入相关信息.\n\n");
        printf("输入学号（输入'#'结束）:");
        scanf("%s",info->xuehao);    /*输入学号并校验*/
        if(info->xuehao[0]=='#') break;               /*如果学号首字符为#则结束输入*/
        printf("输入用户名:");
        scanf("%s",info->yonghuming);      /*输入用户名，并进行校验*/
        printf("输入昵称:");
        scanf("%s",info->nicheng);      /*输入昵称，并进行校验*/
        printf("输入余额:");
        do{
                scanf("%lf",&info->yue);      /*输入余额，并进行校验*/
                if(info->yue<0)/*确保成绩在0~100之间*/
                    printf("非法数据，请重新输入！\n");      /*出错提示信息*/
            }while(info->yue<0);

        info->next=h;              /*将头结点做为新输入结点的后继结点*/
        h=info;            /*新输入结点为新的头结点*//*没排序前,后输入的数据将排在最上*/
    }
    return(h);                    /*返回头指针*/
}
/*显示模块*/
void print(x *h)
{
    int i=0;               /* 统计记录条数*/
    x *p;            /*移动指针*/
    p=h;                   /*初值为头指针*/
    if(p==NULL)
    {
        printf("\n    很遗憾，空表中没有任何记录可供显示！\n");
    }
    else
    {
        printf("****************** 用户信息 *******************\n");
        printf("  用户名　  昵称         学号           余额　\n");
        printf("-----------------------------------------------\n");
        while(p!=NULL)
        {
            i++;
            printf("  %-11s %-11s %-11s %6.2f\n", p->yonghuming, p->nicheng,p->xuehao,p->yue);
            p=p->next;
        }
        printf("********************************************\n\n");
    }
}
/*红包分配*/
void hongbao(int n,double all)
{
    int i;
    double a[10000];
    srand(time(NULL));
    srand((unsigned)time(0));
    for(i=1; i<n; i)
    {
        a[i]=(double)rand()/RAND_MAX*all;
        if(a[i]>0)
            {
            all-=a[i];
            printf("第%d个红包是%.2f\n",i,a[i]);
            i++;
        }
    }
    a[n]=all;
    printf("第%d个红包是%.2f\n",n,all);

}
/*抢红包*/
double qiang(x *h,int n,double *q)
{
    x *p;
    int i,j;
    int t;
    double sum;
    t=n;
    char s[50],pan[23];
    printf("抢红包\n");
    do
    {
        printf("请输入您的用户名：");
        scanf("%s",s);/*输入用户名*/
        p=h;                             /*将头指针赋给p*/
        while(p!=NULL&&strcmp(p->yonghuming,s))/*当记录的用户名不是要找的，并且指针不为空时*/
            p=p->next;                   /*移动指针，指向下一结点，继续查找*/
        if(p==NULL)                      /*指针为空，说明未能找到所要的结点*/
            printf("\n您输入的是%s，很遗憾，查无此人！\n",s);
        else
        {
            t--;
            printf("您领到的是第%d个红包,金额为%.2f\n",n-t,q[n-t]);
            p->yue+=q[n-t];
            printf("是否要继续抢红包？(Y/N)*若不继续则剩余红包将全部返回给发红包者\n");
            scanf("%s",pan);
            if(pan[0]=='N'||pan[0]=='n')
            {
                sum=0.0;
                for(j=n-t+1; j<=n; j++)
                {
                    sum+=q[j];
                }

                return sum;
            }



        }
    }
    while(t>0);
    return 0;

}
/*发红包*/
void fa(x *h)
{
    int i,n;
    double a[100],all;
    x *p;
    int shu;

   double m,sheng;
    char s[50];/*存放用户名的字符数*/
    printf("请输入您的用户名: ");
    scanf("%s",s);/*输入用户名*/
    /*strcpy(qi->yhm,s);*/
    p=h;                             /*将头指针赋给p*/
    while(p!=NULL&&strcmp(p->yonghuming,s))/*当记录的用户名不是要找的，并且指针不为空时*/
        p=p->next;                   /*移动指针，指向下一结点，继续查找*/
    if(p==NULL)                      /*指针为空，说明未能找到所要的结点*/
        printf("\n您输入的是%s，很遗憾，查无此人！\n",s);
    else
    {
        printf("您目前的余额是%.2f\n",p->yue);
        printf("请输入红包金额(前面要加-号)：");

        do{
                scanf("%lf",&m);      /*输入红包金额，并进行校验*/
                if(m>=0||-m>p->yue)/*确保金额大于0且小于余额*/
                    printf("非法数据，请重新输入！\n");      /*出错提示信息*/
            }while(m>=0);
            p->yue=p->yue+m;
            printf("请输入红包数额(整数)：");
            do{
                scanf("%d",&shu);      /*输入红包金额，并进行校验*/
                if(shu<=0)/*确保成绩在0~100之间*/
                    printf("非法数据，请重新输入！\n");      /*出错提示信息*/
            }while(shu<=0);
            all=-m;
            n=shu;
            system("CLS");
            srand(time(NULL));
    srand((unsigned)time(0));
    for(i=1; i<n; i)
    {
        a[i]=(double)rand()/RAND_MAX*all;
        if(a[i]>0)
            {
            all-=a[i];
            printf("第%d个红包是%.2f\n",i,a[i]);
            i++;
        }
    }
    a[n]=all;
    printf("第%d个红包是%.2f\n",n,all);
   sheng=qiang(h,n,a);
   p->yue+=sheng;




    }
}

/*查找记录模块*/
void search(x *h)
{
    x *p;                      /*移动指针*/
    char s[50];                      /*存放用户名的字符数组*/
    printf("请输入您要查找的用户名:\n");
    scanf("%s",s);                   /*输入用户名*/
    p=h;                             /*将头指针赋给p*/
    while(p!=NULL&&strcmp(p->yonghuming,s))/*当记录的用户名不是要找的，并且指针不为空时*/
        p=p->next;                   /*移动指针，指向下一结点，继续查找*/
    if(p==NULL)                      /*指针为空，说明未能找到所要的结点*/
        printf("\n您要查找的是%s，很遗憾，查无此人！\n",s);
    else                             /*显示找到的记录信息*/
    {
        printf("****************** Found *********************\n");
        printf("  用户名　  昵称          学号         余额　\n");
        printf("----------------------------------------------\n");

            printf("  %-11s %-11s %-11s %6.2f\n", p->yonghuming, p->nicheng,p->xuehao,p->yue);

        printf("********************************************\n\n");
    }
}


/*在链表头部添加用户信息*/
x  *insert(x *h)
{
    x *info;                   /*p指向插入位置，q是其前驱，info指新插入记录*/
    int i,n=0;
    printf("\n请添加新记录！\n");
    info=(x *)malloc(sizeof(x)); /*申请空间*/
    if(!info)
    {
        printf("\n内存分配失败！");
        return NULL;                         /*返回空指针*/
    }
    printf("输入学号:");

    do
    {
        scanf("%s",info->xuehao);    /*输入学号并校验*/
        if(info->xuehao[0]=='#')
            printf("非法数据，请重新输入！\n");      /*出错提示信息*/
    }while(info->xuehao[0]=='#');
    printf("输入用户名:");
    scanf("%s",info->yonghuming);  /*以下是待插入数据的录入和处理，具体同创建模块同*/
    printf("输入昵称:");
    scanf("%s",info->nicheng);
    printf("输入余额:");
    do
    {
        scanf("%lf",&info->yue);      /*输入余额，并进行校验*/
        if(info->yue<0)/*确保成绩在0~100之间*/
        printf("非法数据，请重新输入！\n");      /*出错提示信息*/
   }while(info->yue<0);
    info->next=NULL;           /*设后继指针为空*/

    info->next=h;              /*将指针赋值给p*/

   h=info;                    /*将指针赋值给q*/

    printf("\n ----已经添加 %s 到链表头部！----\n",info->yonghuming);
    return(h);                 /*返回头指针*/
}
/*删除用户信息*/
x *delete1(x *h)
{
    char k[5];                  /*定义字符串数组，用来确认删除信息*/
    x *p,*q;                /*p为查找到要删除的结点指针，q为其前驱指针*/
    char s[20];                 /*存放学号*/
    printf("请输入要删除用户的学号：\n");      /*显示提示信息*/
    scanf("%s",s);              /*输入要删除记录的学号*/
    q=p=h;                      /*给q和p赋初值头指针*/
    while(p!=NULL&&strcmp(p->xuehao,s))   /*当记录的学号不是要找的，或指针不为空时*/
    {
        q=p;                    /*将p指针值赋给q作为p的前驱指针*/
        p=p->next;               /*将p指针指向下一条记录*/
    }
    if(p==NULL)                 /*如果p为空，说明链表中没有该结点*/
        printf("\n很遗憾，链表中没有您要删除的学号为 %s 的用户！\n",s);
    else                        /*p不为空，显示找到的记录信息*/
    {
        printf("****************** Found ********************\n");
        printf("  用户名　  昵称          学号         余额　\n");
        printf("---------------------------------------------\n");
            printf("  %-11s %-11s %-11s %6.2f\n", p->yonghuming, p->nicheng,p->xuehao,p->yue);

        printf("********************************************\n\n");

        do{
            printf("您确实要删除此记录吗?(y/n):");
            scanf("%s",k);
        }while(k[0]!='y'&&k[0]!='n');

        if(k[0]!='n')               /*删除确认判断*/
        {
            if(p==h)                /*如果p==h，说明被删结点是头结点*/
                h=p->next;           /*修改头指针指向下一条记录*/
            else
                q->next=p->next;    /*不是头指针，将p的后继结点作为q的后继结点*/
            free(p);                /*释放p所指结点空间*/
            printf("\n 已经成功删除学号为 %s 的用户的记录！\n",s);
        }
    }
    return(h);                      /*返回头指针*/
}
/*保存数据到文件模块*/
void save(x *h)
{
   FILE *fp;                                      /*定义指向文件的指针*/
   x *p;                                    /*定义移动指针*/
   char outfile[20];                              /*保存输出文件名*/
   printf("请输入导出文件名，例如：d:\\xds\\score.txt:\n");
   scanf("%s",outfile);
   if((fp=fopen(outfile,"wb"))==NULL)             /*为输出打开一个二进制文件，如没有则建立*/
   {
      printf("不能打开文件，文件保存失败！\n");
   }
   else
   {
       p=h;                                       /*移动指针从头指针开始*/
       while(p!=NULL)                             /*如p不为空*/
       {
          fwrite(p,sizeof(x),1,fp);         /*写入一条记录*/
          p=p->next;                              /*指针后移*/
       }
       fclose(fp);                                /*关闭文件*/
       printf("-----所有记录已经成功保存至文件%s中!-----\n",outfile);   /*显示保存成功*/
   }
}
/*导入信息模块*/
x *load()
{
   x *p,*q,*h=NULL;                         /*定义记录指针变量*/
   FILE *fp;                                      /* 定义指向文件的指针*/
   char infile[20];                               /*保存文件名*/
   printf("请输入导入文件名，例如：d:\\xds\\score.txt:\n");
   scanf("%s",infile);                            /*输入文件名*/
   if((fp=fopen(infile,"rb"))==NULL)              /*打开一个二进制文件，为读方式*/
   {
        printf("文件打开失败！\n");               /*如不能打开，返回头指针*/
        return h;
   }
   p=(x *)malloc(sizeof(x));          /*申请空间*/
   if(!p)
   {
        printf("内存分配失败!\n");                /*如没有申请到，则内存溢出*/
        return h;                                 /*返回空头指针*/
   }
   h=p;                                           /*申请到空间，将其作为头指针*/
   while(!feof(fp))                               /*循环读数据直到文件尾结束*/
   {
       if(1!=fread(p,sizeof(x),1,fp))
            break;                                  /*如果没读到数据，跳出循环*/
        p->next=(x *)malloc(sizeof(x)); /*为下一个结点申请空间*/
        if(!p->next)
        {
             printf("内存分配失败!\n");             /*如没有申请到，则内存溢出*/
             return h;
        }
        q=p;                                        /*保存当前结点的指针，作为下一结点的前驱*/
        p=p->next;                                  /*指针后移，新读入数据链到当前表尾*/
    }
    q->next=NULL;                                  /*最后一个结点的后继指针为空*/
    fclose(fp);                                    /*关闭文件*/
    printf("已经成功从文件%s导入数据!!!\n",infile);
    return h;                                      /*返回头指针*/
}
/*零钱明细*/
void ling(x *h)
{
    char s[50];
   int i=0;               /* 统计记录条数*/
    x *p;            /*移动指针*/

    printf("请输入您要查找的用户名:\n");
    scanf("%s",s);                   /*输入用户名*/
     p=h;                       /*将头指针赋给p*/
     printf("****************** 余额查询 ****************\n");
     printf("  用户名        余额　\n");
        printf("------------------------------------------\n");
         while(p!=NULL&&strcmp(p->yonghuming,s))/*当记录的用户名不是要找的，并且指针不为空时*/
        p=p->next;                   /*移动指针，指向下一结点，继续查找*/
    if(p==NULL)                      /*指针为空，说明未能找到所要的结点*/
        printf("\n您要查找的是%s，很遗憾，查无此人！\n",s);
    else /*显示找到的记录信息*/                  /*初值为头指针*/
    {

            i++;
            printf("  %-11s      %.2f\n",p->yonghuming ,p->yue);

        p=p->next;

    }

    printf("********************************************\n\n");


}
void denglu()
{
    x *head = NULL;       /*链表定义头指针*/

    for(;;)                     /*无限循环*/
    {
        switch(menu_select())   /*调用主菜单函数，返回值整数作开关语句的条件*/
        {
             case 1: system("CLS");head=create(head);break;        /*创建链表*/
             case 2: system("CLS");print(head);break;          /*显示全部记录*/
             case 3: system("CLS");fa(head);break;      /*发红包*/
             case 4: system("CLS");printf("     请先发红包\n");fa(head);break;/*抢红包*/
             case 5: system("CLS");search(head);break;         /*查找记录*/
             case 6: system("CLS");head=insert(head);break;     /*插入记录*/
             case 7: system("CLS");head=delete1(head);break;   /*删除记录*/
             case 8: system("CLS");save(head);break;           /*保存文件*/
             case 9: system("CLS");head=load();break;          /*读文件*/
             case 10:system("CLS");ling(head) ;break;/*零钱明细*/
             case 11: iMainMenu();                    /*程序结束*/
        }
    }
}

/******主函数开始*******/
int main()
{
    system("color 4e");         /*调DOS命令清屏，可用color ?命令查看命令格式*/
    iMainMenu();
    return 0;
}

