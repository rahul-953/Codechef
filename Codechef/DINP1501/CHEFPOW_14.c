#include<stdio.h>
#include<math.h>
int main(){int n,a[31];scanf("%d",&n);int i;for(i=0;i<=30;i++){a[i]=pow(2,i);if(a[i]>n)break;}i--;int j=i;for(;j>0;j--){if((n-a[j])>=0 )n-=a[j];else a[j]=-1;}for(j=1;j<=i;j++)if(a[j]!=-1)printf("%d ",a[j]);return 0;}