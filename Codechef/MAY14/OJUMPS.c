#include<stdio.h>

int main()
{
	long long int  a;
	scanf("%lld",&a);

	if((a)%3==0 || (a)%6==1 )	
	printf("yes\n");
	
	else
	printf("no\n");

	return 0;

}
