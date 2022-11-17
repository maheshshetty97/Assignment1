import java.util.*;
import java.util.stream.Collectors;
public class NearMisses {

	public static void main(String[] args) {
		/*
		 TITLE: Program to find Fermat’s Last Theorem Near Misses
		 Name of the file that holds the program: NearMisses
		 External files necessary to run this  program: None
		 External files your program creates: None
		 The names of any programmers working on the program: Paladi Mahesh Gowtham, Jitta Nikhil Reddy
		 Email adress: maheshgowthampalad@lewis.edu,nikhilreddyjitta@lewis.edu
       Course number:60500
       Section number:005
		 The date we  finished the program and submitted it: 8th November, 17th November
		 An explaination of what program does: This program finds the near misses of Fermat's Last theorem
		 Resources we used to complete the program: Websites namely stackoverflow and geeksforgeeks
		  */
		Scanner s=new Scanner(System.in);
		System.out.println("Please enter n between 2 and 12");
		int n=s.nextInt(); // n is the power in the equation (x^n + y^n = z^n)
		
	    //  This loop is  to ensure that n to be entered between 2 and 12
		while(n<3 || n>12)
		{
			System.out.println("Please enter n between 2 and 12");
			n=s.nextInt();
		}
		System.out.println("Enter k");
		int k=s.nextInt(); // K is the outerlimit of x and y
		while(k<10)
		{
			System.out.print("Please enter k greater than 9");
			k=s.nextInt();
		}
		int sum=0;     // sum if to find the sum of x^n and y^n
		int i=0;       // i is to find : [(x^n + y^n) - z^n]
		int j=0;       // j is to find  z+1^n-  (x^n + y^n)
		int miss=0;   // To store actual miss value   
		int res;      // To store ralative miss
		int len;      // length of arraylist
		ArrayList<Integer> relMiss = new ArrayList<>();   //arraylist to store the miss values which is used to find the smallest miss so far

		// loops for combination of x,y and z
		for(int x=10;x<=k;x++)
		{
			for(int y=10;y<=k;y++)
			{
				sum=(int)(Math.pow(x, n) + Math.pow(y, n));  
				for (int z=10;z<100;z++)
				{
					if(   (int)(Math.pow(z, n))   <sum && sum < (int)(Math.pow((z+1), n))      ) 
							{
						           i= sum-(int)(Math.pow(z, n)) ;
						           j= (int)(Math.pow((z+1), n))-sum ;
							}
					if(i<j)   
						{
						miss=i;
                          }
					
					
					else {
						miss=j;
											
				}
					res=  (miss%(sum));  // Calculating relative miss
					
					relMiss.add(miss);    // adding miss value to arraylist
					len=relMiss.size();
					List<Integer> copy =relMiss.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());    // copying arraylist to sort which is used to find the smallest miss

                  copy.sort(Comparator.naturalOrder());


					if(len>3)
					{

						
						if(copy.get(2)==relMiss.get(len-1))        // condition for the smallest miss
							{
								
								System.out.println("x value "+x);   
								System.out.println("y value is "+y);
								System.out.println("z value is "+z);
								System.out.println("The actual miss is "+miss);
								System.out.println("Relative miss is "+res);
									
							}
					
						
					}
						
					

				}
			}
			
		}
	
		
		
	}
	

}