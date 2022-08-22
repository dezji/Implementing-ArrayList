package com.dezji;


import java.util.Iterator;

public class MyArrayListIterator<E> implements Iterator<E> {

	int currentIndex = 0;
	
	MyArrayList<E> list = null;
	
	public MyArrayListIterator(MyArrayList<E> list) {
		this.list = list;
	}
	
	@Override
	public boolean hasNext() {
		if (currentIndex < list.size()) {
			return true;
		}
		return false;
	}

	@Override
	public E next() {
		E result = null;
		
		try {
			result = list.get(currentIndex++);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
}