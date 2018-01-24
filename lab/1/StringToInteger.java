	/**
	* file: StringToInteger.java
	* author: Vivek Vellaiyappan Surulimuthu
	* course: MSCS630S
	* assignment: Lab 1
	* due date: Wednesday, January 24, 2018.
	* version: 1.0
	* 
	* This file contains the conversion of the given string into corresponding integer numbers.
	*/
	
	/*
	*	StringToInteger
	*	
	* This class implements the conversion of given alphabet string into integer numbers
	* 
	* Objective: a to z or A to Z to be mapped from 0 to 25 with space as 26
	*/
	
	import java.util.Scanner;
	
	public class StringToInteger {
		// Static Global Constant Variable TOKEN_65 used 
		// 	to reduce from the converted alphabet ascii value to obtain 
		// 	objective of this program.
		// for e.g.: "CAR" is converted into { 2 0 17 } 
		// 		(i.e.) (ASCII)"CAR"	- TOKEN_65^(times_the_alphabets_length_individually) 
		// 								=> 67-65 65-65 82-65 => 2 0 17 
		static final int TOKEN_65 = 65;
		
		public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			String str = scan.nextLine();
			
			System.out.println("Received String: " + str);
			
			scan.close();
		}
		
	}
	
	
	
	



