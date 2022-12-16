#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

#define USER_FILE "data.bin1"
int geshu=0;
typedef struct xinxi     /*����ṹ������,�洢�û���Ϣ*/
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
void vPutList(x *head)//������ȫ�������ļ���
{
    FILE *fp;
    fp = fopen("D:\\data.txt","w"); //�����뱣���·��
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
    printf("��ȡ����ʧ�ܣ����ļ�������"),getchar(),exit(0);
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
 int iIs_Account_Exist(char *name,x *info)//�ж�������˺��Ƿ�ע���
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
int iIs_Effective_Password(char *password,char *password0)   //�˺���������֤����
{

            if(!strcmp(password0,password))
                  return 1;
            else
                  return 0;

}
int iIs_Effective_Name(char *name) //�ж��˺ŵ���Ч��
{
    if(name[0]>='a'&&name[0]<='z'||name[0]>='0'&&name[0]<='9'||name[0]>='A'&&name[0]<='Z')
    return 1;
    else
    return 0;
 }
 void vRegisterPw()//ע���˺ź�����
{   x info;
    char name[20]={0},pw[50]={0};
    printf("�������˺�(����Ӣ���ַ�):   ");
    scanf("%s",name);
    while(!iIs_Effective_Name(name))
    {
        printf("���˺Ų����Ϲ涨�������������˺�:    ");
        scanf("%s",name);
    }
    while(iIs_Account_Exist(name,&info))
    {   printf("���˺��ѱ�ע�ᣬ�����������˺�:   ");
        scanf("%s",name);
    }
    strcpy(info.yonghuming,name);
    while(printf("����������(����6λ�ַ�):   "),scanf("%s",info.pw),printf("��������һ��: "),scanf("%s",pw), !iIs_Effective_Password(info.pw,pw))
    printf("\n�������벻һ�£�������¼�룡����\n");
    vWrite_data(&info);
}
void vInput_password(char *password0)//�������룬����֧��6λ���ַ�
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
                        printf("\b \b");// ����֧���˸��ʵ��
                    }
                }
                else if(!(ch<='9' && ch>='0'))//�������������ֻ��������
                {
                    if(i>0)
                    {
                        i--;
                    }
                 }
                 else
                {
                    password0[i++]=ch;//��¼ʱ������*��ʽ��ʾ
                    printf("*");
                }
            }
            password0[i]='\0';
}

int iLogin_Password()//��¼
{
    char name[20]={0},pw[50]={0};
    int f=0;
    int a;
    x info,*h=NULL;
     for(;;)
    {
      printf("�������˺�:   ");
      scanf("%s",name);
      printf("����������:   ");
      vInput_password(pw);
            if  (!iIs_Effective_Name(name) || !iIs_Account_Exist(name,&info) || !iIs_Effective_Password(info.pw,pw) )
            {
                printf("\n�û������������\n");
                printf("��ѡ��1.ע��\n      2.�ٴ���������\n");
                scanf("%d",&a);
                if(a==1)
                {
                    vRegisterPw();printf("\nע��ɹ�,��ת����¼ҳ��:\n");system("CLS");
                }
            }
            else
            {printf("\n��ӭʹ��\n");system("CLS");denglu(); return 1;}
    }
     return 0;
}
void iMainMenu()    //�ú����������������������
{
       system("cls");//ʵ������
       printf("-----------------------\n");
       printf("   ��ѡ������ķ�ʽ:\n");
       printf("   1.ע��\n");
       printf("   2.��¼\n");
       printf("   3.�˳�\n");
       printf("����������ѡ��:");
       int m;
       while(fflush(stdin),!scanf("%d",&m) || m<1 || m>3)//�ų��������������fflush(stdin)������뻺����
    {
        printf("   �����������,����������: ");

    }
    switch(m)
         {
           case 1:
             vRegisterPw();printf("\nע��ɹ�,��ת����¼ҳ��:\n");system("CLS");          //ע��
           case 2:
             if (!iLogin_Password()) return; break;            //��¼
           case 3:
             exit(0);                      //�˳�
         }
}

/*�˵�����������ֵΪ���������޸�*/
int menu_select()
{
    char s[3];
    int c;
    printf("\n         ***************���˵�************\n");
    printf("             1. �����û���Ϣ\n");
    printf("             2. ��ʾ�û���Ϣ\n");
    printf("             3. �����\n");
    printf("             4. �����\n");
    printf("             5. ���Ҽ�¼\n");
    printf("             6. �����û���Ϣ\n");
    printf("             7. ɾ���û���Ϣ\n");
    printf("             8. ��������Ϣ���浽�ļ�\n");
    printf("             9. ���ļ��ж������м�¼\n");
    printf("             10. ����ѯ\n");
    printf("             11. �˳�\n");
    printf("         ***********************************\n\n");
    do
    {
        printf("         ��ѡ�����(1-11):");
        scanf("%s",s);
        c=atoi(s);
    }while(c<0||c>11); /*ѡ�����0~9֮������*/
    return(c); /*����ѡ�����������ݸ���������Ӧ�ĺ���*/
}

/*���������������¼�빦�ܣ��½���ڱ�ͷ����*/
x *create(x *h)
{
    int i;
    double s;
    x *info;             /*h:ͷ���ָ�룻info:�½��ָ��*/
    for(;;)
    {
        info=(x *)malloc(sizeof(x));  /*����ռ�*/
        if(!info)                                 /*���ָ��infoΪ��*/
        {
             printf("\n�ڴ����ʧ��");
             return NULL;                         /*���ؿ�ָ��*/
        }
        printf("\n�밴������ʾ���������Ϣ.\n\n");
        printf("����ѧ�ţ�����'#'������:");
        scanf("%s",info->xuehao);    /*����ѧ�Ų�У��*/
        if(info->xuehao[0]=='#') break;               /*���ѧ�����ַ�Ϊ#���������*/
        printf("�����û���:");
        scanf("%s",info->yonghuming);      /*�����û�����������У��*/
        printf("�����ǳ�:");
        scanf("%s",info->nicheng);      /*�����ǳƣ�������У��*/
        printf("�������:");
        do{
                scanf("%lf",&info->yue);      /*������������У��*/
                if(info->yue<0)/*ȷ���ɼ���0~100֮��*/
                    printf("�Ƿ����ݣ����������룡\n");      /*������ʾ��Ϣ*/
            }while(info->yue<0);

        info->next=h;              /*��ͷ�����Ϊ��������ĺ�̽��*/
        h=info;            /*��������Ϊ�µ�ͷ���*//*û����ǰ,����������ݽ���������*/
    }
    return(h);                    /*����ͷָ��*/
}
/*��ʾģ��*/
void print(x *h)
{
    int i=0;               /* ͳ�Ƽ�¼����*/
    x *p;            /*�ƶ�ָ��*/
    p=h;                   /*��ֵΪͷָ��*/
    if(p==NULL)
    {
        printf("\n    ���ź����ձ���û���κμ�¼�ɹ���ʾ��\n");
    }
    else
    {
        printf("****************** �û���Ϣ *******************\n");
        printf("  �û�����  �ǳ�         ѧ��           ��\n");
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
/*�������*/
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
            printf("��%d�������%.2f\n",i,a[i]);
            i++;
        }
    }
    a[n]=all;
    printf("��%d�������%.2f\n",n,all);

}
/*�����*/
double qiang(x *h,int n,double *q)
{
    x *p;
    int i,j;
    int t;
    double sum;
    t=n;
    char s[50],pan[23];
    printf("�����\n");
    do
    {
        printf("�����������û�����");
        scanf("%s",s);/*�����û���*/
        p=h;                             /*��ͷָ�븳��p*/
        while(p!=NULL&&strcmp(p->yonghuming,s))/*����¼���û�������Ҫ�ҵģ�����ָ�벻Ϊ��ʱ*/
            p=p->next;                   /*�ƶ�ָ�룬ָ����һ��㣬��������*/
        if(p==NULL)                      /*ָ��Ϊ�գ�˵��δ���ҵ���Ҫ�Ľ��*/
            printf("\n���������%s�����ź������޴��ˣ�\n",s);
        else
        {
            t--;
            printf("���쵽���ǵ�%d�����,���Ϊ%.2f\n",n-t,q[n-t]);
            p->yue+=q[n-t];
            printf("�Ƿ�Ҫ�����������(Y/N)*����������ʣ������ȫ�����ظ��������\n");
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
/*�����*/
void fa(x *h)
{
    int i,n;
    double a[100],all;
    x *p;
    int shu;

   double m,sheng;
    char s[50];/*����û������ַ���*/
    printf("�����������û���: ");
    scanf("%s",s);/*�����û���*/
    /*strcpy(qi->yhm,s);*/
    p=h;                             /*��ͷָ�븳��p*/
    while(p!=NULL&&strcmp(p->yonghuming,s))/*����¼���û�������Ҫ�ҵģ�����ָ�벻Ϊ��ʱ*/
        p=p->next;                   /*�ƶ�ָ�룬ָ����һ��㣬��������*/
    if(p==NULL)                      /*ָ��Ϊ�գ�˵��δ���ҵ���Ҫ�Ľ��*/
        printf("\n���������%s�����ź������޴��ˣ�\n",s);
    else
    {
        printf("��Ŀǰ�������%.2f\n",p->yue);
        printf("�����������(ǰ��Ҫ��-��)��");

        do{
                scanf("%lf",&m);      /*��������������У��*/
                if(m>=0||-m>p->yue)/*ȷ��������0��С�����*/
                    printf("�Ƿ����ݣ����������룡\n");      /*������ʾ��Ϣ*/
            }while(m>=0);
            p->yue=p->yue+m;
            printf("������������(����)��");
            do{
                scanf("%d",&shu);      /*��������������У��*/
                if(shu<=0)/*ȷ���ɼ���0~100֮��*/
                    printf("�Ƿ����ݣ����������룡\n");      /*������ʾ��Ϣ*/
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
            printf("��%d�������%.2f\n",i,a[i]);
            i++;
        }
    }
    a[n]=all;
    printf("��%d�������%.2f\n",n,all);
   sheng=qiang(h,n,a);
   p->yue+=sheng;




    }
}

/*���Ҽ�¼ģ��*/
void search(x *h)
{
    x *p;                      /*�ƶ�ָ��*/
    char s[50];                      /*����û������ַ�����*/
    printf("��������Ҫ���ҵ��û���:\n");
    scanf("%s",s);                   /*�����û���*/
    p=h;                             /*��ͷָ�븳��p*/
    while(p!=NULL&&strcmp(p->yonghuming,s))/*����¼���û�������Ҫ�ҵģ�����ָ�벻Ϊ��ʱ*/
        p=p->next;                   /*�ƶ�ָ�룬ָ����һ��㣬��������*/
    if(p==NULL)                      /*ָ��Ϊ�գ�˵��δ���ҵ���Ҫ�Ľ��*/
        printf("\n��Ҫ���ҵ���%s�����ź������޴��ˣ�\n",s);
    else                             /*��ʾ�ҵ��ļ�¼��Ϣ*/
    {
        printf("****************** Found *********************\n");
        printf("  �û�����  �ǳ�          ѧ��         ��\n");
        printf("----------------------------------------------\n");

            printf("  %-11s %-11s %-11s %6.2f\n", p->yonghuming, p->nicheng,p->xuehao,p->yue);

        printf("********************************************\n\n");
    }
}


/*������ͷ������û���Ϣ*/
x  *insert(x *h)
{
    x *info;                   /*pָ�����λ�ã�q����ǰ����infoָ�²����¼*/
    int i,n=0;
    printf("\n������¼�¼��\n");
    info=(x *)malloc(sizeof(x)); /*����ռ�*/
    if(!info)
    {
        printf("\n�ڴ����ʧ�ܣ�");
        return NULL;                         /*���ؿ�ָ��*/
    }
    printf("����ѧ��:");

    do
    {
        scanf("%s",info->xuehao);    /*����ѧ�Ų�У��*/
        if(info->xuehao[0]=='#')
            printf("�Ƿ����ݣ����������룡\n");      /*������ʾ��Ϣ*/
    }while(info->xuehao[0]=='#');
    printf("�����û���:");
    scanf("%s",info->yonghuming);  /*�����Ǵ��������ݵ�¼��ʹ�������ͬ����ģ��ͬ*/
    printf("�����ǳ�:");
    scanf("%s",info->nicheng);
    printf("�������:");
    do
    {
        scanf("%lf",&info->yue);      /*������������У��*/
        if(info->yue<0)/*ȷ���ɼ���0~100֮��*/
        printf("�Ƿ����ݣ����������룡\n");      /*������ʾ��Ϣ*/
   }while(info->yue<0);
    info->next=NULL;           /*����ָ��Ϊ��*/

    info->next=h;              /*��ָ�븳ֵ��p*/

   h=info;                    /*��ָ�븳ֵ��q*/

    printf("\n ----�Ѿ���� %s ������ͷ����----\n",info->yonghuming);
    return(h);                 /*����ͷָ��*/
}
/*ɾ���û���Ϣ*/
x *delete1(x *h)
{
    char k[5];                  /*�����ַ������飬����ȷ��ɾ����Ϣ*/
    x *p,*q;                /*pΪ���ҵ�Ҫɾ���Ľ��ָ�룬qΪ��ǰ��ָ��*/
    char s[20];                 /*���ѧ��*/
    printf("������Ҫɾ���û���ѧ�ţ�\n");      /*��ʾ��ʾ��Ϣ*/
    scanf("%s",s);              /*����Ҫɾ����¼��ѧ��*/
    q=p=h;                      /*��q��p����ֵͷָ��*/
    while(p!=NULL&&strcmp(p->xuehao,s))   /*����¼��ѧ�Ų���Ҫ�ҵģ���ָ�벻Ϊ��ʱ*/
    {
        q=p;                    /*��pָ��ֵ����q��Ϊp��ǰ��ָ��*/
        p=p->next;               /*��pָ��ָ����һ����¼*/
    }
    if(p==NULL)                 /*���pΪ�գ�˵��������û�иý��*/
        printf("\n���ź���������û����Ҫɾ����ѧ��Ϊ %s ���û���\n",s);
    else                        /*p��Ϊ�գ���ʾ�ҵ��ļ�¼��Ϣ*/
    {
        printf("****************** Found ********************\n");
        printf("  �û�����  �ǳ�          ѧ��         ��\n");
        printf("---------------------------------------------\n");
            printf("  %-11s %-11s %-11s %6.2f\n", p->yonghuming, p->nicheng,p->xuehao,p->yue);

        printf("********************************************\n\n");

        do{
            printf("��ȷʵҪɾ���˼�¼��?(y/n):");
            scanf("%s",k);
        }while(k[0]!='y'&&k[0]!='n');

        if(k[0]!='n')               /*ɾ��ȷ���ж�*/
        {
            if(p==h)                /*���p==h��˵����ɾ�����ͷ���*/
                h=p->next;           /*�޸�ͷָ��ָ����һ����¼*/
            else
                q->next=p->next;    /*����ͷָ�룬��p�ĺ�̽����Ϊq�ĺ�̽��*/
            free(p);                /*�ͷ�p��ָ���ռ�*/
            printf("\n �Ѿ��ɹ�ɾ��ѧ��Ϊ %s ���û��ļ�¼��\n",s);
        }
    }
    return(h);                      /*����ͷָ��*/
}
/*�������ݵ��ļ�ģ��*/
void save(x *h)
{
   FILE *fp;                                      /*����ָ���ļ���ָ��*/
   x *p;                                    /*�����ƶ�ָ��*/
   char outfile[20];                              /*��������ļ���*/
   printf("�����뵼���ļ��������磺d:\\xds\\score.txt:\n");
   scanf("%s",outfile);
   if((fp=fopen(outfile,"wb"))==NULL)             /*Ϊ�����һ���������ļ�����û������*/
   {
      printf("���ܴ��ļ����ļ�����ʧ�ܣ�\n");
   }
   else
   {
       p=h;                                       /*�ƶ�ָ���ͷָ�뿪ʼ*/
       while(p!=NULL)                             /*��p��Ϊ��*/
       {
          fwrite(p,sizeof(x),1,fp);         /*д��һ����¼*/
          p=p->next;                              /*ָ�����*/
       }
       fclose(fp);                                /*�ر��ļ�*/
       printf("-----���м�¼�Ѿ��ɹ��������ļ�%s��!-----\n",outfile);   /*��ʾ����ɹ�*/
   }
}
/*������Ϣģ��*/
x *load()
{
   x *p,*q,*h=NULL;                         /*�����¼ָ�����*/
   FILE *fp;                                      /* ����ָ���ļ���ָ��*/
   char infile[20];                               /*�����ļ���*/
   printf("�����뵼���ļ��������磺d:\\xds\\score.txt:\n");
   scanf("%s",infile);                            /*�����ļ���*/
   if((fp=fopen(infile,"rb"))==NULL)              /*��һ���������ļ���Ϊ����ʽ*/
   {
        printf("�ļ���ʧ�ܣ�\n");               /*�粻�ܴ򿪣�����ͷָ��*/
        return h;
   }
   p=(x *)malloc(sizeof(x));          /*����ռ�*/
   if(!p)
   {
        printf("�ڴ����ʧ��!\n");                /*��û�����뵽�����ڴ����*/
        return h;                                 /*���ؿ�ͷָ��*/
   }
   h=p;                                           /*���뵽�ռ䣬������Ϊͷָ��*/
   while(!feof(fp))                               /*ѭ��������ֱ���ļ�β����*/
   {
       if(1!=fread(p,sizeof(x),1,fp))
            break;                                  /*���û�������ݣ�����ѭ��*/
        p->next=(x *)malloc(sizeof(x)); /*Ϊ��һ���������ռ�*/
        if(!p->next)
        {
             printf("�ڴ����ʧ��!\n");             /*��û�����뵽�����ڴ����*/
             return h;
        }
        q=p;                                        /*���浱ǰ����ָ�룬��Ϊ��һ����ǰ��*/
        p=p->next;                                  /*ָ����ƣ��¶�������������ǰ��β*/
    }
    q->next=NULL;                                  /*���һ�����ĺ��ָ��Ϊ��*/
    fclose(fp);                                    /*�ر��ļ�*/
    printf("�Ѿ��ɹ����ļ�%s��������!!!\n",infile);
    return h;                                      /*����ͷָ��*/
}
/*��Ǯ��ϸ*/
void ling(x *h)
{
    char s[50];
   int i=0;               /* ͳ�Ƽ�¼����*/
    x *p;            /*�ƶ�ָ��*/

    printf("��������Ҫ���ҵ��û���:\n");
    scanf("%s",s);                   /*�����û���*/
     p=h;                       /*��ͷָ�븳��p*/
     printf("****************** ����ѯ ****************\n");
     printf("  �û���        ��\n");
        printf("------------------------------------------\n");
         while(p!=NULL&&strcmp(p->yonghuming,s))/*����¼���û�������Ҫ�ҵģ�����ָ�벻Ϊ��ʱ*/
        p=p->next;                   /*�ƶ�ָ�룬ָ����һ��㣬��������*/
    if(p==NULL)                      /*ָ��Ϊ�գ�˵��δ���ҵ���Ҫ�Ľ��*/
        printf("\n��Ҫ���ҵ���%s�����ź������޴��ˣ�\n",s);
    else /*��ʾ�ҵ��ļ�¼��Ϣ*/                  /*��ֵΪͷָ��*/
    {

            i++;
            printf("  %-11s      %.2f\n",p->yonghuming ,p->yue);

        p=p->next;

    }

    printf("********************************************\n\n");


}
void denglu()
{
    x *head = NULL;       /*������ͷָ��*/

    for(;;)                     /*����ѭ��*/
    {
        switch(menu_select())   /*�������˵�����������ֵ������������������*/
        {
             case 1: system("CLS");head=create(head);break;        /*��������*/
             case 2: system("CLS");print(head);break;          /*��ʾȫ����¼*/
             case 3: system("CLS");fa(head);break;      /*�����*/
             case 4: system("CLS");printf("     ���ȷ����\n");fa(head);break;/*�����*/
             case 5: system("CLS");search(head);break;         /*���Ҽ�¼*/
             case 6: system("CLS");head=insert(head);break;     /*�����¼*/
             case 7: system("CLS");head=delete1(head);break;   /*ɾ����¼*/
             case 8: system("CLS");save(head);break;           /*�����ļ�*/
             case 9: system("CLS");head=load();break;          /*���ļ�*/
             case 10:system("CLS");ling(head) ;break;/*��Ǯ��ϸ*/
             case 11: iMainMenu();                    /*�������*/
        }
    }
}

/******��������ʼ*******/
int main()
{
    system("color 4e");         /*��DOS��������������color ?����鿴�����ʽ*/
    iMainMenu();
    return 0;
}

