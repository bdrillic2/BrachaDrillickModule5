package doubleLinkedListWithIterator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListIIITest {
	private LinkedListIIIWithIterator<Integer> theList;

	@BeforeEach
	void setUp() throws Exception {
		theList = new LinkedListIIIWithIterator<Integer>();
	}

	@Test
	void testLinkedListIII() {
		assertEquals(0,theList.size());
	}

	@Test
	void testAddFirst() {
		assertEquals(0, theList.size());
		assertThrows(UnderFlowException.class,
				()->theList.removeFirst());
		theList.addFirst(100);
		assertEquals(1,theList.size());
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addFirst(50);
		assertEquals(50,theList.getFirst());
		assertEquals(100,theList.getLast());
		assertEquals(2,theList.size());
		theList.removeFirst();
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
	}

	@Test
	void testGetFirst() {
		assertThrows(UnderFlowException.class,
				()->theList.removeFirst());
		theList.addFirst(100);
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addFirst(50);
		assertEquals(50,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addFirst(20);
		theList.removeFirst();
		assertEquals(50,theList.getFirst());
		assertEquals(100,theList.getLast());
	}

	
	@Test
	void testRemoveFirst() {
		theList.addFirst(100);
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addFirst(50);
		assertEquals(50,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addFirst(20);
		theList.removeFirst();
		assertEquals(50,theList.getFirst());
		theList.removeFirst();
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.removeFirst();
		assertThrows(UnderFlowException.class,
				()-> theList.getFirst());
		assertEquals(0,theList.size());
		assertThrows(UnderFlowException.class,
				()->theList.getLast()); 
	}

	@Test
	void testAddLast() {
		assertThrows(UnderFlowException.class,()->theList.getLast());
		theList.addLast(100);
		assertEquals(1, theList.size());
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addLast(150);
		assertEquals(2, theList.size());
		assertEquals(100,theList.getFirst());
		assertEquals(150,theList.getLast());
		theList.addFirst(50);
		assertEquals(3, theList.size());
		assertEquals(50,theList.getFirst());
		assertEquals(150,theList.getLast());
		
	}

	@Test
	void testGetLast() {
		assertThrows(UnderFlowException.class,()->theList.getLast());
		theList.addLast(100);
		assertEquals(100,theList.getFirst());
		assertEquals(100,theList.getLast());
		theList.addLast(150);
		assertEquals(100,theList.getFirst());
		assertEquals(150,theList.getLast());
		theList.addFirst(50);
		assertEquals(50,theList.getFirst());
		assertEquals(150,theList.getLast());
		theList.addLast(200);
		assertEquals(200, theList.getLast());
		assertEquals(50,theList.getFirst());
	}

	@Test
	void testRemoveLast() {
		assertThrows(UnderFlowException.class,()->theList.removeLast());
		theList.addLast(100);
		assertEquals(100,theList.getLast());
		theList.addLast(150);
		assertEquals(150,theList.getLast());
		theList.addFirst(50);
		assertEquals(50,theList.getFirst());
		assertEquals(150,theList.getLast());
		theList.addLast(200);
		assertEquals(200, theList.getLast());
		assertEquals(50,theList.getFirst());
		assertEquals(4,theList.size());
		theList.removeLast();
		assertEquals(3, theList.size());
		assertEquals(150, theList.getLast());
		theList.removeLast();
		assertEquals(2,theList.size());
		assertEquals(100,theList.getLast());
		theList.removeLast();
		assertEquals(1,theList.size());
		assertEquals(50,theList.getLast());
		assertEquals(50,theList.getFirst());
		theList.removeLast();
		assertEquals(0,theList.size());
		assertThrows(UnderFlowException.class,()->theList.getLast());
		assertThrows(UnderFlowException.class,()->theList.getFirst());
	}
	

	@Test
	void testRemove() {
		System.out.println(theList.toString());
		assertThrows(UnderFlowException.class,
				()-> theList.remove((Integer)400));
		theList.addFirst(500);
		theList.addFirst(200);
		theList.addLast(700);
		theList.addLast(800);
		theList.addFirst(100);
		System.out.println(theList.toString());
		assertEquals(false, theList.remove((Integer)50));
		assertEquals(true,theList.remove((Integer)500));
		assertEquals(4, theList.size());
		assertEquals(true, theList.remove((Integer)100));
		assertEquals(200, theList.getFirst());
		assertEquals(true, theList.remove((Integer)200));
		assertEquals(700,theList.getFirst());
		theList.remove((Integer)800);
		assertEquals(700, theList.getLast());
		assertEquals (1, theList.size());
		theList.remove((Integer)700);
		assertEquals(0, theList.size());
	}

	@Test
	void testSize() {
		assertEquals(0, theList.size());
		theList.addFirst(500);
		theList.addFirst(200);
		theList.addLast(300);
		theList.addLast(100);
		assertEquals(4, theList.size());
		theList.removeFirst();
		assertEquals(3, theList.size());
		theList.removeLast();
		assertEquals(2, theList.size());
		theList.removeFirst();
		theList.removeLast();
		assertEquals(0, theList.size());
	}

	@Test
	void testToString() {
		theList.addFirst(500);
		theList.addFirst(200);
		theList.addLast(300);
		theList.addLast(100);
		
		assertEquals("[200, 500, 300, 100]", theList.toString());
		
	}
/*** 
	@Test
	void testInsertAt() {
		assertThrows(IndexOutOfBoundsException.class,
			()-> theList.insertAt(-1, 100)
			);
		assertThrows(IndexOutOfBoundsException.class,
			() -> theList.insertAt(1,100));
		theList.insertAt(0,  100);
		assertEquals(1, theList.size());
		assertEquals(100, theList.getFirst());
		assertEquals(100, theList.getLast());
		theList.insertAt(0, 50);
		assertEquals(2, theList.size());
		assertEquals(50, theList.getFirst());
		assertEquals(100, theList.getLast());
		theList.insertAt(2, 200);
		assertEquals(3, theList.size());
		assertEquals(200, theList.getLast());
		theList.insertAt(1, 150);
		assertEquals(4, theList.size());
		assertEquals(50, theList.getFirst());
		assertEquals(200, theList.getLast());
		assertEquals("[50, 150, 100, 200]", theList.toString());
	
	}
**/
	@Test
	void testInsertAt() {
		assertThrows(IndexOutOfBoundsException.class,
			()-> theList.insertAt(-1, 100)
			);
		assertThrows(IndexOutOfBoundsException.class,
			() -> theList.insertAt(1,100));
		theList.insertAt(0,  100);
		assertEquals(1, theList.size());
		assertEquals(100, theList.getFirst());
		assertEquals(100, theList.getLast());
		theList.insertAt(0, 50);
		assertEquals(2, theList.size());
		assertEquals(50, theList.getFirst());
		assertEquals(100, theList.getLast());
		System.out.println(theList);
		System.out.println("before insert at 2 " + theList);
		theList.insertAt(2, 200);
		System.out.println("after insert at 2 " + theList);
				
		assertEquals(3, theList.size());
		assertEquals(200, theList.getLast());
		System.out.println("before insert at 1 " + theList);
		theList.insertAt(1, 150);
		System.out.println("after insert at 1 " + theList);
		assertEquals(4, theList.size());
		assertEquals(50, theList.getFirst());
		assertEquals(200, theList.getLast());
		assertEquals("[50, 150, 100, 200]", theList.toString());
	
	}

}
