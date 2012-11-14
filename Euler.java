package projecteuler;

import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;

public class Euler {

	/**
	 * @param args
	 */
	
	Scanner scan;
	int[][] nums;
	int maxsum=0;
	
	
	public Euler()
	{		
		
	}
	
	public void parse(File f)
	{
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//test
//		while(scan.hasNextLine()){
//		System.out.println( scan.nextLine() );
//		}
		
	}
	
	
	//can add nums regularly using biginteger or add manually... 
	public void e13()
	{
		//refer locally to file instead
		File f = new File("nums-p13");
		parse(f);
		addNums();
	}
	
	private void addNums()
	{
		BigInteger[] nums = new BigInteger[100];
		int i =0;
		while(scan.hasNextLine()){
			nums[i] = new BigInteger(scan.nextLine());
			i++;
		}
		
		BigInteger sum = BigInteger.ZERO;
		for(BigInteger num: nums){
			sum = sum.add(num);
		}		
		System.out.println("e13: "+ sum.toString());	
	}
	
	//project euler 18 and 67
	public void e18(File f, int n)
	{
		
		parse(f);
		
		nums = new int[n][n];
		
		//fill array with numbers (or tree)
		//can use hasNext instead of hard-wired numbers
		for(int i=0;i<nums.length;i++){				
			for(int j=0;j<=i;j++){ //make sure data correct
			nums[i][j]= scan.nextInt();
			}			
		}		
		// System.out.println( recurseArray(0,0,0) );
		System.out.println("pyramid sum: "+ bottomUp(n) );
	}
	
	// O(n) solution..
	private int bottomUp(int n)
	{
		for(int i=n-2;i>=0;i--){
			for(int j=0;j<=i;j++){ //*
			getMax(i, j);
			}
		}
		return nums[0][0];
	}	
	
	private void getMax(int i, int j)
	{
		int a = nums[i+1][j];
		int b = nums[i+1][j+1];
		int max = (a > b) ? a : b;
		nums[i][j] += max;
	}	
	
	//these kind of stuff r way faster in mathematica
	public void e34()
	{
		int curiousSum =0;
		for(Integer i=10;i<500000; i++){
			
			String str = i.toString();	
			int fsum = 0;
			
			int[] nums = toDigits(i);
			
			for(int n: nums){
				fsum+=factorial(n);
			}
			
			if(fsum == i){
				System.out.println("CuriousNum:"+ fsum);
				curiousSum += fsum;
			}
		}
		System.out.println("curiousSum: "+ curiousSum);
	}
	
	public void e30()
	{
		int totalsum =0;
		for(int i=2;i<600000;i++){
			int[] nums = toDigits(i);
			int psum = 0;
			for(int n:nums){
				psum += Math.pow(n, 5);
			}
			if(psum==i){
				System.out.println(psum);
				totalsum += psum;
			}
			
		}
		System.out.println("e30 "+ totalsum);
		
	}
	
	//can use mod or tostring and back
	private int[] toDigits(Integer n)
	{
		String num = n.toString();
		int[] digits = new int[num.length()];
		for(int j=0;j<num.length(); j++){
			digits[j] = Integer.parseInt(num.substring(j,j+1));
		}
		return digits;
	}	
	
	public int factorial(int n)
	{
		int result =1;
		for(int i=1;i<=n;i++){
			result *= i;
		}
		return result;
	}

}
