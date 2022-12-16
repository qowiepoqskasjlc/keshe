/*********************************************************************************
 ****  FileName:  demo.c
 ****  Function:  ӡ�µĴ�ӡ
 ****  Usage:     demo.exe  xxxx.bmp  xxx.txt
 ****  Author:    linshuheng
 ****  Date:      2020-06-03
 *********************************************************************************/
//#include <CONIO.H>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <malloc.h>
#include <string.h>
char strk[4];
char stri[120];
typedef unsigned char BYTE;
typedef unsigned short WORD;
typedef unsigned long DWORD;

/****  The file header of bmp file λͼ�ļ�ͷ*****/
#include <pshpack2.h>
typedef struct tagBITMAPFILEHEADER {
    WORD bfType;
    DWORD bfSize;
    WORD bfReserved1;
    WORD bfReserved2;
    DWORD bfoffBits;
} BITMAPFILEHEADER;
#include <poppack.h>

/****  The information header of bmp file λͼ��Ϣͷ*****/
typedef struct tagBITMAPINFOHEADER {
    DWORD biSize;
    DWORD biWidth;
    DWORD biHeight;
    WORD  biPlanes;
    WORD  biBitCount;
    DWORD biCompress;
    DWORD biSizeImage;
    DWORD biXPeIsPerMeter;
    DWORD biYPeIsPerMeter;
    DWORD biCIrUsed;
    DWORD biClrImprotant;
} BITMAPINFOHEADER;

/****  The RGB data of bmp file ͼ��RGB����*****/
typedef struct tagRGBDATA{
    BYTE rgbBlue;
    BYTE rgbGreen;
	BYTE rgbRed;
} RGBDATA;
int main(int argc, char *argv[])
{

	RGBDATA *bmpData=NULL;	//ͼ������ָ��
	FILE *fp;				//BMP�ļ�ָ��
	FILE *fq;
//	long i,j,k;
	long width=120;			//ͼ����
	long height=120;		//ͼ��߶�
	long dataSize=width*height;
	BITMAPFILEHEADER bmfHeader;
	BITMAPINFOHEADER bmiHeader;
	int  i, len,j,k;
    unsigned char  BM[100];
    char  str[200];
	if(argc<2)
	{
		printf("\n    ��ָ����Ҫ���ɵ�BMP�ļ�����\n");
		printf("\n    ����1����cmd�������룺 demo.exe  xxxx.bmp�� xxx.txt ��س�ִ�У�\n");
		printf("\n    ����2����VC�Ĺ�����������Ӳ����� xxxx.bmp��xxx.txt��������У�\n");
		printf("\n    ���ܣ� ������������ָ��ӡ��\n\n");
		exit(0);
	}

	printf("\n    ********************************************************************************\n");
	printf("\n         ��л��ʹ��txt�ļ�����ӡ�³���                 \n");
	printf("\n             ���ߣ� ����ޱ               \n");
	printf("\n             ���ڣ�2021��3��04��                 \n");
	printf("\n             Ŀ�ģ�ӡ�����ɳ���       \n");
	printf("\n             ���ܣ����ݲ�ͬ�����壬�����Ӧ���ĸ����ּ��ɴ�ӡ\n\n");
	printf("\n    ********************************************************************************\n\n");

    //��һ�������������и������ļ����½�һBMP�ļ�����ʱ����һ�����ļ�
	if((fp=fopen(argv[1],"wb+"))==NULL)
	{
		printf("Cannot open BMP file!");
		exit(0);
	}
	if((fq=fopen(argv[2],"r"))==NULL)
	{
		printf("Cannot open TXT file!");
		exit(0);
 	}
 	 printf("�������ĸ����֣�");
    scanf("%s",BM);
    for(len=0;BM[len]!='\0';len++);
    for(i=0;i<len;i++)
	printf("BM[%d]=%x\n",i,BM[i]); //����"��"���������ΪCF�� F2

    printf("������ת�����ַ�����ʾ��");
//	fread(&txt,sizeof(TXT),1,fq);

	//�ڶ��������ļ�ͷ���ݲ�д��BMP�ļ�
	bmfHeader.bfType=0x4d42;
	bmfHeader.bfSize=14+40+width*height*3;
	bmfHeader.bfReserved1=0;
	bmfHeader.bfReserved2=0;
	bmfHeader.bfoffBits=0x36;
    fwrite(&bmfHeader, sizeof(BITMAPFILEHEADER), 1, fp);

	//������������Ϣͷ���ݲ�д��BMP�ļ�
	bmiHeader.biSize=40;
	bmiHeader.biWidth=width;
	bmiHeader.biHeight=height;
	bmiHeader.biPlanes=1;
	bmiHeader.biBitCount=24;
	bmiHeader.biCompress=0;
	bmiHeader.biSizeImage=width*height*3;
	bmiHeader.biXPeIsPerMeter=0;
	bmiHeader.biYPeIsPerMeter=0;
	bmiHeader.biCIrUsed=0;
	bmiHeader.biClrImprotant=0;
    fwrite(&bmiHeader, sizeof(BITMAPINFOHEADER), 1, fp);

	//���Ĳ�����ͼ��RGB���ݲ�д��BMP�ļ�
	//�����㹻�ڴ棬��bmpDataָ������ڴ棬���ڴ��ͼ������ص��RGB����ֵ
	if((bmpData=(RGBDATA*)malloc(width*height*3))==NULL)
	{
		printf("bmpData memory malloc error!");
	}
	for( i=0;i<len;i++)
		sprintf(str+2*i,"%x",BM[i]); //���룭���ַ���������str����
	for( i=0;i<height;i++)
		{

		for(  j=0;j<width;j++)
		{
		 k=(height-i-1)*width + j;//����bmpͼƬ�е�i�е�j��ͼ��������bmpData[]�����е�λ��

		if(i==0||i==1||i==2||i==3||j==3||j==1||j==2||j==0||i==116||i==117||i==118||i==119||j==118||j==119||j==117||j==116)//���ú�ɫ�߿�
		{
			bmpData[k].rgbBlue=0;
			bmpData[k].rgbGreen=0;
			bmpData[k].rgbRed=255;//��ɫ����ֵ
		}
		else
		{
			bmpData[k].rgbBlue=255;//��ɫ����ֵΪ��255
			bmpData[k].rgbGreen=255;
			bmpData[k].rgbRed=255;
		}
	}
}
    int count=1,w;
    int dx[4]={4,56,4,56};//Ϊ�˰����ĸ��ֵ�λ�ã�����ÿ��������ͬ��ƫ��
    int dy[4]={56,56,4,4};
		for( i=0;i<16;i+=4)
		{
			strncpy(strk,str+i,4);
			rewind(fq);//��ͷ��ʼһ����Ѱ��
			while(!feof(fq))
			{
				fgets(stri,sizeof(stri)-1,fq);//һ��������Ѱ��
				if(strstr(stri,strk))//�ҵ��˶�Ӧ����
				{

						for( w=0;w<56;w++)//����56�е�����ת��Ϊ��Ӧ�ĺ��ɫ��
						{
							fgets(stri,sizeof(stri)-1,fq);
							int flag=0;
							for( j=0;j<63;j++)
							{
								k=(height-w-1-dx[i/4])*width + j+dy[i/4]-flag;//flag�Ľ������� ��
								if(stri[j]==',')//����������ţ�Ҫ���ԣ����õĲ���Ϊɫ�������ƶ�flag����λ
								{
									flag++;
									continue;
								}
								if(stri[j]=='X')
								{
								bmpData[k].rgbBlue=0;
								bmpData[k].rgbGreen=0;
								bmpData[k].rgbRed=255;//��ɫ����ֵΪ��255
								}
								else
								{
								bmpData[k].rgbBlue=255;//��ɫ����ֵΪ��255
								bmpData[k].rgbGreen=255;
								bmpData[k].rgbRed=255;
								}
							}
						}
						break; //�ҵ���һ���֣�������ѭ�����´ӵ�һ������ʡʱ��
				}

			}
		}

	fwrite(bmpData,sizeof(RGBDATA),dataSize,fp);//��bmpData��ָ�ڴ��е�RGB����һ����д��BMP�ļ�

	printf("\n    ��ϲ����BMP�ļ��Ѿ��ɹ����ɣ�\n");
	printf("\n    ���ڵ�ǰĿ¼�²鿴���ɵ�BMP�ļ�%s\n\n",argv[1]);

	free(bmpData);	//�ͷ�bmpData��ָ���ڴ�ռ�
	bmpData=NULL;	//��bmpDataΪ��ָ��
	fclose(fp);		//�ر�fp��ָ�ļ�
	fclose(fq);

}
