package com.dezji;

public interface MyList<E> {

	public void insert (int index, E object) throws Exception;
	 public void add (E object);
	 public E get (int index) throws Exception;
	 public int indexOf (E object);
	 public int lastIndexOf (E object);
	 public E remove(int index) throws Exception;
	 public E set (int index, E object) throws Exception;
	 public int size();
	 public void addAll(MyList<E> newItems) throws Exception;
	 public void clear();
	 
}
