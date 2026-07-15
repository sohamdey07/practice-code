#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main()
{
    int n,i=1,ack;
    printf("Enter total number of frame:");
    scanf("%d",&n);

    srand(time(0));
    while(i<=n)
    {
        printf("\nSending frame %d\n",i);
        ack=rand()%2;
        if(ack==1)
        {
            printf("Acknowledgement received for frame %d\n",i);
            i++;
        }
        else{
            printf("Acknowledgement lost! Resending frame %d\n",i);
        }
    }
    printf("All the frames are sent successfully!\n");
    return 0;
}