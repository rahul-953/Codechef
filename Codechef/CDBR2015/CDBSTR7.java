import java.util.*;
import java.util.Scanner;

class CDBSTR7
{
	public static void main(String arg[])
	{
		try
		{
			int t=99,i=0;
			String a,b;
			Scanner sc=new Scanner(System.in);
			
			t=sc.nextInt();
			//sc.next();
			while(t-->0)
			{
				a=sc.next();
				//System.out.println(a);
				
				b=sc.next();
				//				System.out.println(b);
				int aa[]=new int[26];
				int bb[]=new int[26];
				
				for(i=0;i<a.length();i++)
				{	
					//System.out.println(a.charAt(i));
					aa[ a.charAt(i) -97 ]++;
				}
				for(i=0;i<b.length();i++)
				bb[ b.charAt(i) -97 ]++;
				
				int key=0;
				
				for(i=0;i<26;i++)
				{
					if(aa[i]==bb[i])
					continue;

					else
					{
						key=1;
						break;	
					}
				}
				
				if(key==0)
				System.out.println("YES");	
				else
				System.out.println("NO");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}