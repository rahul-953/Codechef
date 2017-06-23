/*

 Naturally, the magical girl is very good at performing magic. She recently met her master wizard Devu, who gifted her R potions of red liquid,
B potions of blue liquid, and G potions of green liquid.

    The red liquid potions have liquid amounts given by r[1], ..., r[R] liters.
    The green liquid potions have liquid amounts given by g[1], ..., g[G] liters.
    The blue liquid potions have liquid amounts given by b[1], ..., b[B] liters.

She want to play with the potions by applying magic tricks on them. In a single magic trick, she will choose a particular color. Then she will pick all the potions of the chosen color and decrease the amount of liquid in them to half (i.e. if initial amount
of liquid is x, then the amount after decrement will be x / 2 where division is integer division, e.g. 3 / 2 = 1 and 4 / 2 = 2).

Because she has to go out of station to meet her uncle Churu, a wannabe wizard, only M minutes are left for her. In a single minute, she can perform at most one magic trick. Hence, she can perform at most M magic tricks.

She would like to minimize the maximum amount of liquid among all of Red, Green and Blue colored potions. Formally Let v be the maximum value of amount of liquid in any potion. We want to minimize the value of v.
Please help her.
Input

First line of the input contains an integer T denoting the number of test cases.
Then for each test case, we have four lines.

The first line contains four space separated integers R, G, B, M. The next 3 lines will describe the amount of different color liquids (r, g, b), which are separated by space.
Output

For each test case, print a single integer denoting the answer of the problem.
Constraints

    1 ≤ T ≤ 1000
    1 ≤ R, G, B, M ≤ 100
    1 ≤ r[i], g[i], b[i] ≤ 10^9

Example

Input:
3
1 1 1 1
1
2
3
1 1 1 1
2
4
6
3 2 2 2
1 2 3
2 4
6 8
Output:
2
4
4

Explanation

Example case 1. Magical girl can pick the blue potion and make its liquid amount half. So the potions will now have amounts 1 2 1. Maximum of these values is 2. Hence answer is 2.

*/

import java.io.*;
import java.util.*;

class PRPOTION
{
	public static void main(String []args)
	{
		int t,i;
		int r,g,b,m;
		Scanner sc=new Scanner(System.in);		
		t=sc.nextInt();

		while((t--)>0)	
		{
			r=sc.nextInt();
			g=sc.nextInt();
			b=sc.nextInt();
			m=sc.nextInt();

			int red[]=new int[r]; 		
			int green[]=new int[g];
			int blue[]=new int[b];

			for(i=0;i<r;i++)
			red[i]=sc.nextInt();

			for(i=0;i<g;i++)
			green[i]=sc.nextInt();

			for(i=0;i<b;i++)
			blue[i]=sc.nextInt();

			int max_r=maximum(red);
			int max_g=maximum(green);
			int max_b=maximum(blue);

			int color=maxi_color(max_r,max_g,max_b);	

			/*
				Color for Red :1 Green:2 Blue: 3
			*/

			for(i=0;i<m;i++)	
			{
				if(color==1)
				divide(red);	
	
				else if(color==2)
				divide(green);	
				
				else
				divide(blue);

				max_r=maximum(red);
				max_g=maximum(green);
				max_b=maximum(blue);

			 	color=maxi_color(max_r,max_g,max_b);	
			}	

			int ans=maxi_tri(max_r,max_g,max_b);
			System.out.println(ans);
		}	
	}

	public static int maximum(int a[])
	{
		int i,max=a[0];

     	for(i=1;i<a.length;i++)
		if(a[i]>max)
		max=a[i];

		return max;	
	}

	public static int maxi_color(int r,int g,int b)
	{
		if(r>=g)
		{
			if(r>=b)
			return 1;
		}

		if(g>=r)
		{
			if(g>=b)
			return 2;
		}

		if(b>=g)
		{
			if(b>=r)
			return 3;
		}
		return -1;
	}

	public static int maxi_tri(int r,int g,int b)
	{
		if(r>=g)
		{
			if(r>=b)
			return r;
		}

		if(g>=r)
		{
			if(g>=b)
			return g;
		}

		if(b>=g)
		{
			if(b>=r)
			return b;
		}
		return -1;
	}

	public static void divide(int a[])
	{
		int i;
		for(i=0;i<a.length;i++)
		a[i]=a[i]/2;		
	}
}

