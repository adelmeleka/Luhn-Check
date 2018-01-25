package main;

import java.util.Scanner;

public class TestCheck {
	
	public static boolean isValid(long number) {
		
		if( !(getSize(number)>=13 && getSize(number)>=16) )
			return false;
			
		else if( !prefixMatched(number))
			return false;
		
		else if( (sumOfDoubleEvenPlace(number)+ sumOfOddPlaces(number))%10 != 0 )
			return false;
		
		return true;
		
	}
	
	public static int getSize(long number) {
		
		int size = 1;
		while(number/10 != 0){
			size++;
			number /=10;
		}
		return size;
		
	}
	
	public static boolean prefixMatched(long number) {
		

		if((int)(number/Math.pow(10,(getSize(number)-2))) == 37 )
			return true;
			
		else if((int)(number/Math.pow(10,(getSize(number)-1))) == 4 | (int)(number/Math.pow(10,(getSize(number)-1))) == 5 | (int)(number/Math.pow(10,(getSize(number)-1))) == 6 )
			return true;
		
		
		return false;
		
	}
		
	public static int getDigit(int number) {
		
		if( getSize(number) == 2)
			return (number/10)+(number%10);
		else
			return number;
		
	}
	
	public static int sumOfDoubleEvenPlace(long number) {
		
		int sum = 0;
		int i = 100; int j = 10;
		
		for(int k=0 ; k<(getSize(number)/2) ; k++){
			
			sum +=  getDigit((int)(2*(number%i)/j)) ;
			i *= 100;
			j *= 100;
			
		}
		return sum;
		
	}
	
	public static int sumOfOddPlaces(long number) {
		
		int sum = 0;
		int i = 10; int j = 1;
		
		for(int k=0 ; k<(int)(Math.ceil(getSize(number)/2.0)) ; k++){
			
			sum +=  (number%i)/j ;
			i *= 100;
			j *= 100;
			
		}
		return sum;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a cerdit card number as a long integer:");
		long number = input.nextLong();
		
		if( isValid(number) )
			System.out.println(number+" is valid");
		else
			System.out.println(number+" is invalid");
		
		
	}

}
