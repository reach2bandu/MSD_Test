package ecommerce;

import java.util.Scanner;

public class Code_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
        Scanner sc = new Scanner(System.in);
        //Enter the number 100
        System.out.println("Enter Any Number");
        num = sc.nextInt();

        for(num=100; num>0; num--)
        {
            System.out.println(num);
                      
        }
        System.out.println("Agile");
		
		for (int x=1; x <= 100; x++){
		    if( x % 3 == 0 ){
		    	System.out.println (x +" Testing divided by 3");
		    }
		    if( x % 5 == 0 ){
		    	System.out.println(x + " Software divided by 5");
		    }
		    if( ( x % 3 != 0 ) && ( x % 5 != 0 ) ){
		    	System.out.println (x);
		    }
		}
	}

}
