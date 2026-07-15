#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main()
{
    int n,ack;
    printf("Enter the total number of frames:");
    scanf("%d",&n);
    srand(time(0));
    int received[n];

    for(int i=0;i<n;i++)
    {
        received[i]=0;
    }

    while(1){
        int complete=1;
        for(int i=0;i<n;i++)
        {
            if(received[i]==0)
            {
                printf("Sending Frame %d\n",(i+1));
                ack=rand()%2;
                if(ack==1)
                {
                    printf("Acknowledgement received for frame %d!\n\n",(i+1));
                    received[i]=1;
                }
                else{
                    printf("Acknowledgement lost for frame %d!\n\n",(i+1));
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(received[i]==0)
            {
                complete=0;
                break;
            }
        }
        if(complete==0)
        {
            printf("\nRetransmitting the lost frames!\n");
        }
        else{
            printf("\nAll the frames successfully transmitted!\n");
            break;
        }
    }
}