package IteraetorClass1;

import java.util.Iterator;
import java.util.Scanner;

public class ManageNumbers {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("How many values would you like to work with today?");
		int qty = keyboard.nextInt();
		NumberList aList = new NumberList(qty);
		
		int choice = menu(keyboard);
		while (choice !=0) {
			switch (choice) {
			    case 1: CountByOnes(aList);
			            break;
			    case 2: CountByEven(aList);
			            break;
			    case 3: CountByOdd(aList);
			            break;
			    case 4: CountByFive(aList);
			            break;
			    case 5: CountDown(aList);
			            break;
			    default: System.out.println("re-enter a valid choice");
			     
		}
			   choice = menu(keyboard);
		}
		System.out.println("Exiting.... have a great day");
		System.exit(0);
	}
	   public static void CountByOnes(NumberList aList) {
		//list the numbers that have been entered into the list
		//one by one
		//and calculate a total
		int total=0;
		for (Integer i : aList) {
			System.out.print(i + " ");
			total += i;
		}
		System.out.println("total is " + total);
	   }
	   
	   public static void CountByEven(NumberList aList) {
		 //list the even number that have been entered into the List
			Iterator<Integer> iter = aList.evenIterator();
			
			while (iter.hasNext()) {
				Integer val = iter.next();
				System.out.println("got next value "+ val);
				
			}
	   }
		
		
       public static void CountByOdd(NumberList aList) {
    	   Iterator<Integer> odditer = aList.oddIterator();
    	   System.out.print("Count by ODD Iterator ");
    	   
    	   while(odditer.hasNext()) {
    		   Integer val = odditer.next();
    		   System.out.println(val + " ");
    	   }
       }
       
       public static void CountByFive(NumberList aList) {
    	   Iterator<Integer> fiviter = aList.fiveIterator();
    	   System.out.print("Count by FIVE Iterator ");
    	   
    	   while(fiviter.hasNext()) {
    		   Integer val = fiviter.next();
    		   System.out.println(val + " ");
    	   }	}
       
       public static void CountDown(NumberList aList) {
			Iterator<Integer> countdowniter = aList.countDownIterator();
			
			while (countdowniter.hasNext()) {
				Integer val = countdowniter.next();
				System.out.println("got next value "+ val);
				
			}
       }
		
		public static int menu(Scanner keyboard) {
			int choice;
			System.out.println("1. Counting by ones"
					+"\n2. count by two's even numbers only"
					+ "\n3. count by two's odd numbers only"
					+ "\n4. count by fives "
					+ "\n5. count down "
					+ "\n0. exit - end the app");
			choice = keyboard.nextInt();
			return choice;
		}
	}
	
	

