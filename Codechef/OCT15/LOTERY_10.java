import java.io.*;
import java.util.*;

class LOTERY_10
{
	public static int GIF(int a,int b)
	{
		float num = (float)a*(float)b;
		float den = b-a;
		
		if(b==a)
		{
			return 2;
		}
		
		if((num/den) < 0)
		return (int)(num/den)-1;	
	
		return (int)(num/den);
	}
	
	public static long gcd(long a, long b)
	{
		long aa = (long)Math.abs(a);
		long bb = (long)Math.abs(b);
		if(bb==0) return 1;
		if (aa<bb) return gcd(bb,aa);
		if (aa%bb==0) return bb;
		else return gcd(aa, aa%bb);
	}
	
	public static int LCM(int a, int b)
	{
		long aa = (long)Math.abs(a);
		long bb = (long)Math.abs(b);
		return (int)((long)(aa*bb)/gcd(aa,bb))%(1000000007);
	}
		
	public static void main(String arg[])throws OutOfMemoryError,IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String input[];
		String arr[];
		
		int t = Integer.parseInt(br.readLine());
		int n,k,m;
		int a,b;
		int mod = 1000000000+7;
		int i,j;
		int c[] = new int[t-1];
		int d[] = new int[t-1];
		
		///System.out.println((int)(-3.14));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		a = Integer.parseInt(input[0]);
		b = Integer.parseInt(input[1]);
		m = Integer.parseInt(input[2]);
		
		arr = br.readLine().split(" ");
		for(i=0;i<t-1;i++)
		c[i] = Integer.parseInt(arr[i])%mod;	
	
		arr = br.readLine().split(" ");
		for(i=0;i<t-1;i++)
		d[i] = Integer.parseInt(arr[i])%mod;	
	
		int F[][] = new int[1002][1002];
		for(i=1;i<=1000;i++)
		F[i][1] = i;	
		
		for(i=2;i<=1000;i++)
		{
			for(j=2;j<=i;j++)
			{
				F[i][j] = (GIF(F[i-1][j-1] , F[i][j-1]))%mod;
				//System.out.print( F[i][j]+" ");
			}
			//System.out.println();
		}
	
		int lcm = F[n][k];
		for(i=1;i<k;i++)
		lcm = (LCM(lcm,F[n][i]))%mod; 	
		
		pw.println(lcm%mod);
		t--;
		int index = 0;
		while(t-->0)
		{
			/***
				Ni = 1 + (A * Answeri-1 + Ci) mod M ,
				Ki = 1 + (B * Answeri-1 + Di) mod Ni,
			*/
			n = 1+(int)((long)a*(long)lcm + (long)c[index])%m;
			k = 1+(int)((long)b*(long)lcm + (long)d[index++])%n;	
			
			//System.out.println("T = "+t+"  N = "+n+"  K = "+k+"  Index = "+index+"  LCM = "+lcm);
			
			//n = (int)Math.abs(n);
			//k = (int)Math.abs(k);
			
			lcm = F[n][k]%mod;
			for(i=1;i<k;i++)
			lcm = LCM(lcm,F[n][i])%mod; 	
			
			pw.println(lcm%mod);
		}
		
		pw.close();
	}
}