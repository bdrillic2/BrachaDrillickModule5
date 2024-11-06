package doubleLinkedListWithIterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

public class UseLinkedListIIIWithIterable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListIIIWithIterator<Integer> theList = new <Integer>LinkedListIIIWithIterator();
		
		//ITERATOR 
		theList.addFirst(500);
		theList.addFirst(200);
		theList.addLast(700);
		theList.addLast(800);
		theList.addFirst(100);
		
		System.out.println("My list is " + theList); 
		//enhanced for loop 
		/* for(Object curElement : theList) {
			System.out.println("My data " + (Integer) curElement );
		}
		*/
		
		Iterator myIter = theList.iterator();
		
		while(myIter.hasNext()) {
			System.out.println("My data " + (Integer)myIter.next() );

		}
		
		System.out.println("\n\n My enhanced for loop ");
		for(Object oo : theList) {
			System.out.println((Integer) oo);
		}
		
		//REVERSE ITERATOR
		System.out.println("\nReverse Iterator");
		Iterator revItr = theList.reverseIterator();
		
		while(revItr.hasNext()) {
			System.out.println(revItr.next());
		}
		
		//Iterator that skips every other element : 
		//System.out.println("\n\n Iterator that skips every other element for list: " + theList);
		
//		Iterator evenOnlyItr = theList.EvenIterator();
//		while(evenOnlyItr.hasNext()) {
//			System.out.println( (Integer)evenOnlyItr.next()); 
//		}
		
		/** REMOVE 
		theList.addFirst(500);
		theList.addFirst(200);
		theList.addLast(700);
		theList.addLast(800);
		theList.addFirst(100);
		
		System.out.println(theList.toString());
		theList.remove((Integer)50);
		System.out.println(theList.toString());
		
		theList.remove((Integer)100);
		System.out.println("Not final " + theList.toString());
		
		theList.remove((Integer)800);
		System.out.println("Final " + theList.toString());
		**/
		
		
		/** insertAt 
		 * 
		 */
		
	
	//theList.insertAt(-1, 100);
	//theList.insertAt(1,100);
	/* 
	theList.insertAt(0,  100);
	System.out.println(" [100]  " + theList);		
	System.out.println(" Should be 1  " + theList.size());
	System.out.println(" Should be 100  " + theList.getFirst());
	System.out.println(" Should be 100  " + theList.getLast());
	
	theList.insertAt(0, 50);
	System.out.println(" Should be 2  " + theList.size());
	System.out.println(" Should be 50  " + theList.getFirst());	
	System.out.println(" Should be 100  " + theList.getLast());
	
	theList.insertAt(2, 200);
	System.out.println(" Should be 3  " + theList.size());
	System.out.println(" Should be 200  " + theList.getLast());		
	
	System.out.println(" Current list   " + theList);	
	theList.insertAt(1, 150);
	System.out.println(" Should be 4  " + theList.size());
	System.out.println(" Should be 50  " + theList.getFirst());	
	System.out.println(" Should be 200  " + theList.getLast());
	System.out.println(" [50, 150, 100, 200]  " + theList);		
*/
		
	}

}
