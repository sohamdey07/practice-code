#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main()
{
    int n,i=0,ack,windowSize;
    printf("Enter total number of frames:");
    scanf("%d",&n);

    printf("Enter window size:");
    scanf("%d",&windowSize);

    srand(time(0));

    while(i<n)
    {
        printf("\nSending frames :");
        for(int j=0;j<windowSize && ((i+j)<n);j++)
        {
            printf("%d\t",(i+j));
        }
        printf("\nWaiting for acknowledgement!\n");
        ack=rand()%2;
        if(ack==1)
        {
            printf("Received frames upto %d\n",i+windowSize-1);
            i+=windowSize;
        }
        else{
            printf("Acknowledgement lost! Resending frames from %d\n",i);
        }
    }
    printf("All the frames are sent successfully!\n");
    return 0;
}
