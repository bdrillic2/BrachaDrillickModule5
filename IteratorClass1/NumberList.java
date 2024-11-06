package IteraetorClass1;

import java.util.ArrayList;
import java.util.Iterator;

public class NumberList implements Iterable<Integer> {
	private ArrayList<Integer> values;
	
	
	public NumberList(int howMany) {
		values = new ArrayList<Integer>(howMany);
		
		for (int i =1;i<=howMany;i++)
		{   
			values.add((Integer)i);
		}
	}


	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return values.iterator();
		
	}
	
	public Iterator<Integer> evenIterator(){
		return new EvenIterator();
	}
	
	class EvenIterator implements Iterator<Integer> {
		private int curCount = 1;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curCount < values.size();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			//grab data
			Integer data = values.get(curCount);
			curCount += 2;
			return data;
		}
		
	}
	
	public Iterator<Integer> oddIterator() {
		return new OddIterator();
	}
	
	class OddIterator implements Iterator<Integer> {

		private int curCount = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curCount < values.size();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Integer data = values.get(curCount);
			curCount += 2;
			return data;
		}
		
	}
	
	public Iterator<Integer> fiveIterator() {
		return new FiveIterator();
	}
	
	class FiveIterator implements Iterator<Integer> {
		private int curCount = 4;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curCount < values.size();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Integer data = values.get(curCount);
			curCount += 5;
			return data;		
		}
		
	}
	
	public Iterator<Integer> countDownIterator() {
		return new CountDownIterator();
	}
	
	class CountDownIterator implements Iterator<Integer> {
		private int curCount = values.size() - 1;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curCount >= 0;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Integer data = values.get(curCount);
			curCount--;
			return data;		
		}
		
	}
		

}

