#include<stdio.h>
#include<string.h>
void divide(char data[],char remainder[],char divisor[])
{
    int n=strlen(data);
    int m=strlen(divisor);
    strcpy(remainder,data);
    for(int i=0;i<=(n-m);i++)
    {
        for(int j=0;j<m;j++)
        {
            remainder[i+j]=(remainder[i+j]==divisor[j])?'0':'1';
        }
    }

}

int main()
{
    char data[100],divisor[20];
    char transmitted[120],received[120],remainder[20];
    int n,m,error=0;

    printf("Enter the input data bits:");
    scanf("%s",data);

    printf("Enter the divisor:");
    scanf("%s",divisor);

    n=strlen(data);
    m=strlen(divisor);

    strcpy(transmitted,data);

    for(int i=0;i<m-1;i++)
    {
        strcat(transmitted,"0");
    }

    divide(transmitted,remainder,divisor);

    printf("\nCRC bits: ");
    for(int i=n;i<n+m-1;i++)
    {
        transmitted[i]=remainder[i];
        printf("%c",remainder[i]);
    }

    printf("\n\nEnter the received bits:");
    scanf("%s",received);

    divide(received,remainder,divisor);

    for(int i=0;i<n+m-1;i++)
    {
        if(remainder[i]=='1')
        {
            error=1;
            break;
        }
    }
    if(error!=0)
    {
        printf("\nError is detected!\n");
    }
    else
    {
        printf("Error not found!\n");
    }

    return 0;
}