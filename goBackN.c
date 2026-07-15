#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main()
{
    int n,window,ack;
    printf("Enter the total number of frames:");
    scanf("%d",&n);
    printf("Enter the size of the window:");
    scanf("%d",&window);

    srand(time(0));

    int i=1,j;
    while(i<=n)
    {
        printf("\n\nSending frames:");
        for(j=i;j<i+window && j<=n;j++)
        {
            printf("%d ",j);
        }
        printf("\n");
        for(j=i;j<i+window && j<=n;j++)
        {
            ack=rand()%2;
            if(ack==1)
            {
                printf("Acknowledgement received for frame %d\n",j);
            }
            else{
                printf("Acknowledgement lost for frame %d\n",j);
                printf("Go Back and retransmitting from frame %d\n",j);
                i=j;
                break;
            }
        }
        if(ack==1)
        {
            i=j;
        }
    }
    printf("\nAll the frames are transmitted successfully!\n");
    return 0;
}