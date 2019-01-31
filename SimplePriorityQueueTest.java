package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {

	private ArrayList<Integer> arrInt;
	private ArrayList<Double> arrDouble;
	private ArrayList<Long> arrLong;
	private ArrayList<String> arrStr;
	private SimplePriorityQueue<Integer> intQueue;
	private SimplePriorityQueue<Double> doubleQueue;
	private SimplePriorityQueue<Long> longQueue;
	private SimplePriorityQueue<String> strQueue;

	@BeforeEach
	public void setUp() {
		arrInt = new ArrayList<Integer>();
		arrInt.add(5);
		arrInt.add(6);
		arrInt.add(7);
		intQueue = new SimplePriorityQueue<Integer>();
		intQueue.insertAll(arrInt);

		arrDouble = new ArrayList<>();
		arrDouble.add(2.0);
		arrDouble.add(3.0);
		arrDouble.add(4.0);
		arrDouble.add(5.0);
		doubleQueue = new SimplePriorityQueue<>();
		doubleQueue.insertAll(arrDouble);

		arrLong = new ArrayList<>();
		arrLong.add((long) 1112345678);
		arrLong.add((long) 1112345679);
		arrLong.add((long) 1112345680);
		longQueue = new SimplePriorityQueue<>();
		longQueue.insertAll(arrLong);

		arrStr = new ArrayList<>();
		arrStr.add("Hello");
		arrStr.add("12Stars");
		arrStr.add("book");
		strQueue = new SimplePriorityQueue<>();
		strQueue.insertAll(arrStr);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void insertTest() {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(5);
		arr1.add(6);
		arr1.add(7);
		ArrayList<Double> arr2 = new ArrayList<>();
		arr2.add(2.0);
		arr2.add(3.0);
		arr2.add(4.0);
		arr2.add(5.0);
		ArrayList<Long> arr3 = new ArrayList<>();
		arr3.add((long) 1112345678);
		arr3.add((long) 1112345679);
		arr3.add((long) 1112345680);
		SimplePriorityQueue q1 = new SimplePriorityQueue();
		q1.insertAll(arr1);
		SimplePriorityQueue q2 = new SimplePriorityQueue();
		q2.insertAll(arr2);
		SimplePriorityQueue q3 = new SimplePriorityQueue();
		q3.insertAll(arr3);

		assertEquals(3, q1.size());
		assertEquals(4, q2.size());
		assertEquals(3, q3.size());
	}

	@Test
	public void findMinTestInteger() {
		int actual = intQueue.findMin();
		assertEquals(5, actual);
	}
	
	@Test
	public void findMinTestDouble() {
		int actual = doubleQueue.findMin();
		assertEquals(5, actual);
	}

	@Test
	public void deleteMinTestInteger() {
		int actual = intQueue.deleteMin();
		assertEquals(5, actual);
		assertEquals(2, intQueue.size());
	}

	@Test
	public void clearTestInteger() {
		intQueue.clear();
		assertThrows(NoSuchElementException.class, () -> {
			intQueue.findMin();
		});
	}

	@Test
	public void insertOrderTestInteger() {
		intQueue.clear();
		intQueue.insert(9);
		intQueue.insert(8);
		assertEquals(8, (int) intQueue.findMin());
	}

	@Test
	public void insertAllTestInteger() {
		SimplePriorityQueue<Integer> testQ = new SimplePriorityQueue<Integer>();

		testQ.insert(4);
		testQ.insert(6);
		testQ.insert(7);
		testQ.insert(5);
		testQ.insert(8);
		assertEquals(5, testQ.size());
	}

	@Test
	public void findMinTestInteger2() {
		SimplePriorityQueue<Integer> testQ = new SimplePriorityQueue<Integer>();

		testQ.insert(4);
		testQ.insert(6);
		testQ.insert(7);
		testQ.insert(5);
		testQ.insert(8);
		assertEquals(4, (int) testQ.findMin());
	}

	@Test
	void insertIntegerTest() {
		SimplePriorityQueue<Integer> testQ = new SimplePriorityQueue<Integer>();

		testQ.insert(1);
		testQ.insert(2);
		assertEquals(2, testQ.size());
	}

}
