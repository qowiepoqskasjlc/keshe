/*********************************************************************************
 ****  FileName:  demo.c
 ****  Function:  印章的打印
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

/****  The file header of bmp file 位图文件头*****/
#include <pshpack2.h>
typedef struct tagBITMAPFILEHEADER {
    WORD bfType;
    DWORD bfSize;
    WORD bfReserved1;
    WORD bfReserved2;
    DWORD bfoffBits;
} BITMAPFILEHEADER;
#include <poppack.h>

/****  The information header of bmp file 位图信息头*****/
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

/****  The RGB data of bmp file 图像RGB数据*****/
typedef struct tagRGBDATA{
    BYTE rgbBlue;
    BYTE rgbGreen;
	BYTE rgbRed;
} RGBDATA;
int main(int argc, char *argv[])
{

	RGBDATA *bmpData=NULL;	//图像数据指针
	FILE *fp;				//BMP文件指针
	FILE *fq;
//	long i,j,k;
	long width=120;			//图像宽度
	long height=120;		//图像高度
	long dataSize=width*height;
	BITMAPFILEHEADER bmfHeader;
	BITMAPINFOHEADER bmiHeader;
	int  i, len,j,k;
    unsigned char  BM[100];
    char  str[200];
	if(argc<2)
	{
		printf("\n    请指定您要生成的BMP文件名！\n");
		printf("\n    方法1：在cmd窗口输入： demo.exe  xxxx.bmp　 xxx.txt 后回车执行！\n");
		printf("\n    方法2：在VC的工程设置中添加参数： xxxx.bmp　xxx.txt后编译运行！\n");
		printf("\n    功能： 根据文字生成指定印章\n\n");
		exit(0);
	}

	printf("\n    ********************************************************************************\n");
	printf("\n         感谢您使用txt文件制作印章程序                 \n");
	printf("\n             作者： 黎丽薇               \n");
	printf("\n             日期：2021年3月04日                 \n");
	printf("\n             目的：印章生成程序       \n");
	printf("\n             功能：根据不同的字体，输入对应的四个文字即可打印\n\n");
	printf("\n    ********************************************************************************\n\n");

    //第一步：用命令行中给出的文件名新建一BMP文件，此时还是一个空文件
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
 	 printf("请输入四个汉字：");
    scanf("%s",BM);
    for(len=0;BM[len]!='\0';len++);
    for(i=0;i<len;i++)
	printf("BM[%d]=%x\n",i,BM[i]); //输入"向"，则其编码为CF　 F2

    printf("将编码转换成字符并显示：");
//	fread(&txt,sizeof(TXT),1,fq);

	//第二步：置文件头数据并写入BMP文件
	bmfHeader.bfType=0x4d42;
	bmfHeader.bfSize=14+40+width*height*3;
	bmfHeader.bfReserved1=0;
	bmfHeader.bfReserved2=0;
	bmfHeader.bfoffBits=0x36;
    fwrite(&bmfHeader, sizeof(BITMAPFILEHEADER), 1, fp);

	//第三步：置信息头数据并写入BMP文件
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

	//第四步：置图像RGB数据并写入BMP文件
	//分配足够内存，让bmpData指向这块内存，用于存放图像各象素点的RGB分量值
	if((bmpData=(RGBDATA*)malloc(width*height*3))==NULL)
	{
		printf("bmpData memory malloc error!");
	}
	for( i=0;i<len;i++)
		sprintf(str+2*i,"%x",BM[i]); //编码－＞字符，并存入str数组
	for( i=0;i<height;i++)
		{

		for(  j=0;j<width;j++)
		{
		 k=(height-i-1)*width + j;//计算bmp图片中第i行第j列图像数据在bmpData[]数组中的位置

		if(i==0||i==1||i==2||i==3||j==3||j==1||j==2||j==0||i==116||i==117||i==118||i==119||j==118||j==119||j==117||j==116)//设置红色边框
		{
			bmpData[k].rgbBlue=0;
			bmpData[k].rgbGreen=0;
			bmpData[k].rgbRed=255;//红色分量值
		}
		else
		{
			bmpData[k].rgbBlue=255;//白色分量值为：255
			bmpData[k].rgbGreen=255;
			bmpData[k].rgbRed=255;
		}
	}
}
    int count=1,w;
    int dx[4]={4,56,4,56};//为了安排四个字的位置，采用每个字做不同的偏移
    int dy[4]={56,56,4,4};
		for( i=0;i<16;i+=4)
		{
			strncpy(strk,str+i,4);
			rewind(fq);//从头开始一行行寻找
			while(!feof(fq))
			{
				fgets(stri,sizeof(stri)-1,fq);//一行行往下寻找
				if(strstr(stri,strk))//找到了对应编码
				{

						for( w=0;w<56;w++)//往下56行的内容转化为对应的红白色块
						{
							fgets(stri,sizeof(stri)-1,fq);
							int flag=0;
							for( j=0;j<63;j++)
							{
								k=(height-w-1-dx[i/4])*width + j+dy[i/4]-flag;//flag的解释如下 ：
								if(stri[j]==',')//如果遇到逗号，要忽略，采用的策略为色块向左移动flag个单位
								{
									flag++;
									continue;
								}
								if(stri[j]=='X')
								{
								bmpData[k].rgbBlue=0;
								bmpData[k].rgbGreen=0;
								bmpData[k].rgbRed=255;//红色分量值为：255
								}
								else
								{
								bmpData[k].rgbBlue=255;//白色分量值为：255
								bmpData[k].rgbGreen=255;
								bmpData[k].rgbRed=255;
								}
							}
						}
						break; //找到了一个字，得跳出循环重新从第一行找起，省时间
				}

			}
		}

	fwrite(bmpData,sizeof(RGBDATA),dataSize,fp);//将bmpData所指内存中的RGB数据一次性写入BMP文件

	printf("\n    恭喜您！BMP文件已经成功生成！\n");
	printf("\n    请在当前目录下查看生成的BMP文件%s\n\n",argv[1]);

	free(bmpData);	//释放bmpData所指的内存空间
	bmpData=NULL;	//置bmpData为空指针
	fclose(fp);		//关闭fp所指文件
	fclose(fq);

}
