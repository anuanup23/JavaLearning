package Custom;

import java.util.Iterator;

public class MyIterableList<T> implements Iterable<T>{
	private T[] items;
	private int size;
	
	public MyIterableList() {
		size = 0;
		items = (T[]) new Object[100];
	}
	
	
	public void add(T item) {
		items[size++] = item;
	}
	
	public T getItem(int index) {
		return items[index];
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyIterator<T>(this);
	}
	
	private class MyIterator<T> implements Iterator<T>{
		
		private MyIterableList<T> myList;
		private int index = 0;
		
		public MyIterator(MyIterableList<T> myList) {
			this.myList = myList;
		}

		@Override
		public boolean hasNext() {
			return index < size;
			//return false;
		}

		@Override
		public T next() {
			return myList.getItem(index++);
		}
		
	}
}
