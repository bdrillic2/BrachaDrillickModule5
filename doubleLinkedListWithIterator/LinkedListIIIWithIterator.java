package doubleLinkedListWithIterator;

import java.util.Iterator;


public class LinkedListIIIWithIterator <T extends Comparable<T>> implements Iterable<T>{
    //each Node points forward and back
    private DNode<T> head;
    private DNode<T> tail;

    
    public LinkedListIIIWithIterator() {   
    	head = null;
    	tail = null; 
 
    }
    
    public void addFirst(T data) {
    //insert a value at the beginning of the list    
    	//TODO 1 create node
    	DNode newNode = new DNode(data);
    	
    	//TODO 2 : If there is no list, create and add
    	if (head == null ) {
    		head = tail = newNode; 
    	}
    	
    	//TODO 2 if this is NOT the first node, attach it -bidirectionally 
    	else {
    		// TODO 2a :  attach new node to head, FORWARD link ==>
    		newNode.setNext(head);
    		//TODO 2b :  attach head's prev pointer to newNode <==
    		head.setPrevious(newNode);
    		//TODO 2b :  move head to point to new node attached 
    		head = newNode; 
    			
    	}
    	
    }
    
    // REMEBER we are returning data 
    public T getFirst() {
   //return direct reference to the first value in the list
    //if list is empty , throw UnderFlowException    
    	
    	//TODO 1 if empty throw UnderFlowException 
    	if (head == null ) {
    		throw new UnderFlowException(); 
    	}
    	//TODO 2 : otherwise return : 
    	return head.getData();
    }
    
    public void removeFirst() {
     //remove the first value from the list 
      
    	//TODO 1 : if list is empty, throw UnderFlowException       
    	if (head == null || tail == null) {
    		throw new UnderFlowException(); 
    	}
    	
    	//TODO 2 : otherwise remove the first node if there is only one node 
    	
    	if(head.getNext() == null) {
    		head = tail = null; 
    		return; 
    	} 
    	
    	//TODO 3 : Otherwise if there is more than one node in the list 
    	// DO NOT forget to set head prev pointer to null once it is moved 
    	// because otherwise, going backwards it is accessible 
    	else {
    		head = head.getNext(); 
    		head.setPrevious(null); 
  
    		return; 
    	}
    	
     
    }
    
    public void addLast(T data) {
     //insert the value at the end of the list   
    	
    	//TODO 1 : create the node to insert 
    	DNode newNode = new DNode(data); 
    	
    	//TODO if the list is empty create the node 
    	if (head == null ) {
    		head = tail = newNode; 
    	}
    	
    	//TODO 2 : Otherwise attach at the end 
    	else {
    		//TODO 2A : attach newNode <=== prev to tail 
    		newNode.setPrevious(tail);
    		//TODO 2B : attach tail ==> link to newNode
    		tail.setNext(newNode);
    		// TODO 2C: move tail to point to last node in list 
    		tail = tail.getNext(); 
    	}
    	
    }
    
    // REMEBER we are returning data 
    public T getLast() {
       //return a direct reference to the last value in the list
        //if list is empty, throw UnderFlowException    
    	
    	//TODO 1 if empty throw UnderFlowException 
    	if (head == null ) {
    		throw new UnderFlowException(); 
    	}
    	
    	//TODO 2 : otherwise remove the first node if there is only one node 
    	return tail.getData(); 
    }
    
    public void removeLast() {
      //remove the last value from the list
        //if list is empty, throw UnderFlowException   
    	
    	//TODO 1 : if nothing there throw UnderFlowException 
    	
    	if (head == null ) {
    		throw new UnderFlowException(); 
    	}
    	
    	//TODO 2 : otherwise if there is only one node 
    	else if (head.getNext() == null) {
    		head = tail = null; 
    		
    	}
    	
    	//TODO 3 : Otherwise remove last node 
    	else {
    		//TODO 3a : move tail back one node 
    		tail = tail.getPrevious(); 
    		//TODO 3b : set tail ==> next to null 
    		tail.setNext(null);
    	}
    	
    }
    
    public int size() {
       //return the quantity of values in the list    
    	DNode curPtr = head; 
    	int sizeOfList = 0; 
    	
    	while(curPtr != null ) {
    		curPtr = curPtr.getNext(); 
    		sizeOfList++; 
    	}
    	
    	return sizeOfList; 
    }
    
    @SuppressWarnings("unused")
	public boolean remove (T data) {
     //if list is empty, throw UnderFlowException
       //remove the reference to 'data' from the list 
    	//TODO 1 : If list is empty throw UnderFlowException : 
    	if (head == null) {
    		throw new UnderFlowException(); 
    	}
    	
    	//TODO 2 : Otherwise let's look for this node 
    	DNode curPtr = head; 
    
    	//TODO 2B: search for node until you hit the end of list or until you find the data 

    	
    	while (curPtr != null && (curPtr.getData().compareTo(data) != 0 )) {
    		// 2B1 : keep moving down the list 
    			curPtr = curPtr.getNext();    
    		
    	}
    	
    	// TODO 2C if we did not find the data, return false bc its not found  
    	if (curPtr == null) {
    		return false;
    	}
    	
    	//TODO 2D : otherwise you found the node, remove and return true 
    	else {
    		// 2D1 if there was only one node 
    		if (head.getNext() == null) {
    			head = tail = null; 
    		}
    		
    		//2D2 it is found at the beginning : 
    		else if(curPtr == head) {
    			// move head ptr to next node 
    			head = head.getNext(); 
    			// set its previous to null 
    			head.setPrevious(null);
    			
    		}
    		
    		//2D3 it is found at the end : 
    		else if((Integer)curPtr.getData().compareTo(tail.getData()) == 0 ) {

    			//move tail back one node 
    			tail = tail.getPrevious(); 
    			//set tail forward to null 
    			tail.setNext(null);

    		}
    		
    		
    		// TODO 2D4 : otherwise it is in the middle - go around curPtr and remove
    		
    		else {
    			DNode tmpCurPtr = curPtr; 
    			// curPtr prev node jump over curptr ===>>>
    			tmpCurPtr.getPrevious().setNext(curPtr.getNext());
    	
    			//curPtr next must jump over curptr and attach to prev link <===
    			tmpCurPtr.getNext().setPrevious(curPtr.getPrevious());
    		}
    		
    		//no matter in else condition what return true because it was found 
    		return true; 
    		} //end else 
    	
    	
    	
    } // end method 
    	
    
    
    public void insertAt(int position, T data) {
     //if 'position' is <0 or greater than the current size of the list , throw IndexOutOfBoundsException
       //otherwise insert a reference to 'data' , at the position requested
      //if 'position' is zero, the value will be inserted at the beginning of the list and become the first value
        //in the list. If 'position' equals the current size, then the value will be inserted at the end of the list
         //and become the last value in the list   
   
    int curSize = size(); 
     if (position < 0 || position > curSize ) {
    	 throw new IndexOutOfBoundsException(); 
     }
    
     //find the position 
     DNode curPtr = head;
     
     
 
     
     // place it at the head of the list 
     DNode newNode = new DNode(data);
     //If the list is empty 
     if (position == 0 && head == null) {
    	 head = tail =  newNode;
    	 return;
     } 
     //place ahead of the list if it is not empty 
     else if (position == 0 && head !=null ) {
    	 //attach newNode to the list 
    	 newNode.setNext(head);
    	 //attach the list to new node 
    	 head.setPrevious(newNode);
    	 //relocated head 
    	 head =  newNode; 
    	 return;
     }
 
     //if it is at the end of the list 
     else if (position == curSize) {
    	 //make newnode connect to tail 
    	 newNode.setPrevious(tail);
    	 //make tail connect to new node 
    	tail.setNext(newNode);
    	 //move tail forward by one 
    	tail = tail.getNext();
    	return;
     }
     //otherwise it is somewhere in the middle 
     // find the correct location 
     else {
	     int loc = 0;
	     //walk down list until you find the correct location
	     
	     while ((loc < position) && ( position < curSize)) {
	    	 curPtr = curPtr.getNext();
	    	 loc += 1; 
	     }
	     
	     // you have arrived at the correct location and it is in the middle of the list 
	    
	     //Let's attach newNode first 
	     //newNode prevpointer <===
	     newNode.setPrevious(curPtr.getPrevious());
	     // newNode next ptr ===>
	     newNode.setNext(curPtr);
	     
	     //Now lets connect the nodes on either side of newNode 
	     //to the left of newNode ==>> 
	     curPtr.getPrevious().setNext(newNode);
	     //to the right of newNode <=== 
	     curPtr.setPrevious(newNode);
	   
	     }
     
    }
    
    
    public String toString() {
        StringBuilder strbuf = new StringBuilder();
        strbuf.append("[");

        DNode curPtr = head;

        while (curPtr != null) {
            strbuf.append(curPtr.getData());
            if (curPtr.getNext() != null) {
                strbuf.append(", ");
            }
            curPtr = curPtr.getNext();
        }

        strbuf.append("]");
        return strbuf.toString();
    }


	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new myIterator();
	}
	
	class myIterator implements Iterator<T> {
		DNode<T> curPtr = head;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curPtr != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = (T)curPtr.getData();
			
			if(curPtr != null) {
				curPtr = curPtr.getNext();
				return data;
			}
			return null;
		}
	}
	
	public Iterator<T> reverseIterator() {
		return new ReverseIterator();
	}
	
	class ReverseIterator implements Iterator<T>{

		DNode<T> curPtr = tail;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curPtr != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T data = (T)curPtr.getData();
			curPtr = curPtr.getPrevious();
			return data;
		}
		
	}
}
