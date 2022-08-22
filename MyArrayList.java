package com.dezji;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>, Iterable<E> {
	
	 private E[] array = null;
	 private int size = 0;
	 private int capacity = 0;

	 @SuppressWarnings("unchecked")
	public MyArrayList() {
	     capacity = 10;
	     array = (E[]) new Object[capacity];
	 }
	
	private void expandIfNeeded() {
        if (size == capacity) {
            int oldCapacity = capacity;
            capacity *= 2;
            
            // allocate new array
            @SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[capacity];
            
            // copy everything from the old array to the new array
            for (int i = 0; i < oldCapacity; i++)
                newArray[i] = array[i];
            
            array = newArray;
        }
    }
    
    public void add (E object) {
        expandIfNeeded();
        array[size++] = object;
    }
    
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i < size - 1)
                result += ", ";
        }
        return result + "]";
    }

    public void insert (int index, E object) throws Exception {
        if (index < 0 || index > size -1)
            throw new Exception ("Invalid index");
        
        expandIfNeeded();
        for (int i = size - 1; i >= index; i--)
            array[i + 1] = array[i];
        array[index] = object;
        size++;
    }
    
    public E get(int index) throws Exception {
        if (index < 0 || index > size -1)
            throw new Exception ("Invalid index");
        return array[index];
    }
    
    public int indexOf (E object) {
        for (int i = 0; i < size; i++)
            if (object.equals(array[i]))
                return i;
        return -1;
    }
    
    public int lastIndexOf (E object) {
        for (int i = size - 1; i >= 0; i--)
            if (object.equals(array[i]))
                return i;
        return -1;
    }
    
    public E remove(int index) throws Exception {
        if (index < 0 || index > size - 1)
            throw new Exception ("Invalid index");
        
        E result = array[index];
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        size--;
        return result;
    }
    
    public E set (int index, E object) throws Exception {
        if (index < 0 || index > size -1)
            throw new Exception ("Invalid index");
        
        E result = array[index];
        array[index] = object;
        return result;
    }

	public int size() {
		return size;
	}
	
	public void addAll(MyList<E> newItems) throws Exception {
		for (int i = 0; i < newItems.size(); i++)
			add(newItems.get(i));
	}

	public void clear() {
		size = 0;
	}
	
	@Override
	public Iterator<E> iterator() {
		MyArrayListIterator<E> result = new MyArrayListIterator<E>(this);
		return result;
	}
    
}
