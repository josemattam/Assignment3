package assign03;

import java.util.Collection;
import java.util.NoSuchElementException;

import java.util.Comparator;

public class SimplePriorityQueue<E> implements PriorityQueue<E> {

	private E[] array;

	private int size;

	private int capacity;

	private Comparator comparator;

	public SimplePriorityQueue() {
		array = (E[]) new Object[16];
		this.size = 0;
		this.capacity = 16;
		this.comparator = new RegularComparator();

	}

	public SimplePriorityQueue(Comparator<? super E> comparator) {
		array = (E[]) new Object[16];
		this.size = 0;
		this.comparator = comparator;
		this.capacity = 16;

	}

	/**
	 * Retrieves, but does not remove, the minimum element in this priority queue.
	 * 
	 * @return the minimum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	@Override
	public E findMin() throws NoSuchElementException {

		if (this.size() == 0)
			throw new NoSuchElementException();
		return array[size - 1];
		/*
		 * // return array[array.length - 1]; E minVal = array[0];
		 * 
		 * for (int i = 0; i < this.size(); i++) { if (comparator.compare(array[i],
		 * minVal) < 0) {//use compareTo and check if comparator!= null minVal =
		 * array[i]; } } return minVal;
		 */
	}

	/**
	 * Retrieves and removes the minimum element in this priority queue.
	 * 
	 * @return the minimum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	@Override
	public E deleteMin() throws NoSuchElementException {

		if (this.size() == 0)
			throw new NoSuchElementException();
		size--;
		return array[size];
		// size--
		/*
		 * E[] newArray = (E[]) new Object[array.length - 1]; for (int i = 0; i <
		 * newArray.length; i++) { newArray[i] = array[i]; } E minVal =
		 * array[array.length - 1]; array = newArray; return minVal;
		 */
	}

	/**
	 * Inserts the specified element into this priority queue.
	 * 
	 * @param item - the element to insert
	 */
	@Override
	public void insert(E item) {

		@SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object[capacity];
		size++;

		int index = binarySearch(this.array, item);

		if (size == capacity)
			capacity *= 2;
		for (int i = 0; i < index; i++) {
			newArray[i] = array[i];

		}
		newArray[index] = item;

		for (int j = index + 1; j < size; j++) {
			newArray[j] = array[j - 1];

		}
		array = newArray;

	}

	/**
	 * 
	 * @param array of elements
	 * @param       item, element that it is searching for
	 * @returns index of where the element fits
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int binarySearch(E[] array, E item)
	{
		if (size == 1)
			return 0;
		int high = size - 1, low = 0, mid = 0;

		while (low <= high) {
			if (low == high)
				if (comparator.compare(item, array[mid]) < 0)	//(((Comparable) item).compareTo(array[mid]) < 0)
					return high;
				else {
					if (high <= 0)
						return 0;
					return high - 1;
				}
			if (low == -1 || high == -1)
				return 0;
			if (high == size)
				return size;
			mid = (low + high) / 2;
			if (comparator.compare(item, array[mid]) < 0) 	//(((Comparable) item).compareTo(array[mid]) < 0) 
			{
				low = mid + 1;
			} 
			else if (comparator.compare(item, array[mid]) > 0)	// (((Comparable) item).compareTo(array[mid]) > 0)
			{
				high = mid - 1;
			} 
			else
				return mid;
		}

		return 0;

	}

	/**
	 * Inserts the specified elements into this priority queue.
	 * 
	 * @param coll - the collection of elements to insert
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insertAll(Collection<? extends E> coll) {
		Object[] arr = coll.toArray();

		for (int i = 0; i < arr.length; i++) {
			insert((E) arr[i]);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {

		for (int i = 0; i < size; i++) {
			if (array[i] != null)
				return false;
		}

		return true;
	}

	@Override
	public void clear() {

		this.size = 0;
		array[0] = null;

	}

	/**
	 * Comparator that defines an ordering among the elements in the array
	 */
	
	protected class RegularComparator implements Comparator<E> {
		
		@SuppressWarnings({ "unchecked", "rawtypes"})
		@Override
		public int compare(E lhs, E rhs) {
			
			return ((Comparable) lhs).compareTo(rhs);
		}

	
}
