package arrayIndexList;

import java.util.ArrayList;
import java.util.List;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		if(index<0 || index>size)throw new IndexOutOfBoundsException("Invalid index does not exist.");
		// ADD CODE AS REQUESTED BY EXERCISES
		if(size==element.length)changeCapacity(size*2);
		for(int i=size-1; i>=index; i--)
			element[i+1]=element[i];
		element[index]=e;
		
		size++;
	}


	public void add(E e) {
		// ADD CODE AS REQUESTED BY EXERCISES
		if(size==element.length)changeCapacity(size*2);
		element[size]=e;
		
		size++;
	}


	public E get(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>size-1)throw new IndexOutOfBoundsException("Invalid index does not exist.");

		// ADD AND MODIGY CODE AS REQUESTED BY EXERCISES
		
		return element[index]; 
	}


	public boolean isEmpty() {
		return size == 0;
	}
	public int capacity(){
		return element.length;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>size-1)throw new IndexOutOfBoundsException("Invalid index does not exist.");

		// ADD AND MODIFY CODE AS REQUESTED BY EXERCISES
		E etr = element[index];
		for(int i=index+1;i<size; i++)
			element[i-1] = element[i];
		element[size-1]=null;
		size--;
		if(element.length-size>MAXEMPTYPOS)
			this.changeCapacity(-2*CAPTOAR);
		return etr;
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index<0 || index>size-1)throw new IndexOutOfBoundsException("Invalid index does not exist.");

		// ADD AND MODIFY CODE AS REQUESTED BY EXERCISES
		E etr = element[index];
		element[index]=e;
		return etr;
	}


	public int size() {
		return size;
	}	
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}


	// The following two methods are to be implemented as part of an exercise
	public Object[] toArray() {
		Object[] newArray = new Object[this.size];
		for(int i=0; i<this.size; i++)
			newArray[i]=this.element[i];
		return newArray;
	}


	
	
	@Override
	public <T1> T1[] toArray(T1[] array) {
		
		T1[] newA = (T1[]) array;
		
		return newA;
	}

}
