import java.io.*;
import java.util.Arrays;
import java.util.Locale;

class BANROB_12
{
	public static void main(String arg[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		long m;
		double p;
		double A = 1000000000d ;
		String nm[];
	
		while(t-->0)
		{
			nm = br.readLine().split(" ");
			m = Long.parseLong(nm[0]);	
			p = Double.parseDouble(nm[1]);	
			int lastTurn = 0; // 0 for Chef 1 for Opponent 
			
			if(m==1)
			pw.format(Locale.UK,"%f 0.00000\n",A);	
			
			else if(m==2)
			pw.format(Locale.UK,"%f %f\n",(A-(A*p)),A*p) ;	
		
			//double MoneyRemain = A*(pow(p,m-1));  // money Remaining after M-1th step
			
			else
			{
				if(p==1.0000)
				pw.format(Locale.UK,"%f 0.0000000\n",A) ;		
				
				else
				pw.format(Locale.UK,"%f %f\n",A-(A*p-(A*p*p)),(A*p-(A*p*p))) ;		
			}
		}
		pw.close();
	}
	
	public static double pow(double base, long exp)
	{        
		if(exp ==0)
		return 1.0;
		
		if(exp ==1)
		return base;
		
	    if(exp % 2 == 0)
		{
			double half = pow(base, exp/2);
			return half * half;
		}
		
		else
		{
			double half = pow(base, (exp -1)/2);
			return base * half * half;
		}       
	}
}