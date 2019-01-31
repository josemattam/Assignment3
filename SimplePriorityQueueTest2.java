package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import assign02.LibraryBookGeneric;

class SimplePriorityQueueTest2<E> {

	private ArrayList<Integer> arrInt;
	private ArrayList<Double> arrDouble;
	private ArrayList<Long> arrLong;
	private ArrayList<String> arrStr;
	private ArrayList<GregorianCalendar> arrGC;
	private SimplePriorityQueue<Integer> intQueue;
	private SimplePriorityQueue<Double> doubleQueue;
	private SimplePriorityQueue<Long> longQueue;
	private SimplePriorityQueue<String> strQueue;
	private SimplePriorityQueue<GregorianCalendar> gcQ;

	@BeforeEach
	public void setUp() {
		arrInt = new ArrayList<Integer>();
		arrInt.add(5);
		arrInt.add(6);
		arrInt.add(7);
		intQueue = new SimplePriorityQueue<Integer>();
		intQueue.insertAll(arrInt);

		arrDouble = new ArrayList<>();
		arrDouble.add(3.0);
		arrDouble.add(4.0);
		arrDouble.add(2.0);
		arrDouble.add(5.0);
		doubleQueue = new SimplePriorityQueue<>();
		doubleQueue.insertAll(arrDouble);

		arrLong = new ArrayList<>();
		arrLong.add((long) 1112345678);
		arrLong.add((long) 1112345680);
		arrLong.add((long) 1112345679);

		longQueue = new SimplePriorityQueue<>();
		longQueue.insertAll(arrLong);

		arrStr = new ArrayList<>();
		arrStr.add("Hello");
		arrStr.add("12Stars");
		arrStr.add("book");
		strQueue = new SimplePriorityQueue<>();
		strQueue.insertAll(arrStr);

		arrGC = new ArrayList<>();
		GregorianCalendar d1 = new GregorianCalendar(1999, 5, 11);
		GregorianCalendar d3 = new GregorianCalendar(2013, 18, 9);
		GregorianCalendar d2 = new GregorianCalendar(2004, 25, 12);
		arrGC.add(d2);
		arrGC.add(d3);
		arrGC.add(d1);
		gcQ = new SimplePriorityQueue<>();
		gcQ.insertAll(arrGC);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void insertTest() {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(5);
		arr1.add(6);
		arr1.add(7);
		arr1.add(9);
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

		assertEquals(4, q1.size());
		assertEquals(4, q2.size());
		assertEquals(3, q3.size());
	}

	@Test
	public void findMinDouble() {
		assertEquals(2, (double) doubleQueue.findMin());
	}

	@Test
	public void deleteMinDouble() {
		assertEquals(2, (double) doubleQueue.deleteMin());
		assertEquals(3, doubleQueue.size());
	}

	@Test
	public void clearDouble() {
		doubleQueue.clear();
		assertThrows(NoSuchElementException.class, () -> {
			doubleQueue.findMin();
		});
	}

	@Test
	public void insertOrderTestDouble() {
		doubleQueue.clear();
		doubleQueue.insert(9.0);
		doubleQueue.insert(8.0);
		assertEquals(8.0, (double) doubleQueue.findMin());
	}

	@Test
	public void insertAllTestDouble() {
		SimplePriorityQueue<Double> testQ = new SimplePriorityQueue<Double>();

		testQ.insert(4.0);
		testQ.insert(6.0);
		testQ.insert(7.0);
		testQ.insert(5.0);
		testQ.insert(8.0);
		assertEquals(5.0, testQ.size());
	}

	public void capacityTest() {
		ArrayList<Integer> testQ = new ArrayList<>();
		SimplePriorityQueue<Integer> testP = new SimplePriorityQueue<Integer>();
		Random rng = new Random();
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 101; i++) {
			int inp = rng.nextInt();
			min = Math.max(min, inp);
			testQ.add(inp);
		}
		testP.insertAll(testQ);
		assertEquals(100, testP.size());
		assertEquals(min, (int) testP.findMin());
	}

	@Test
	public void findMinTestDouble2() {
		SimplePriorityQueue<Double> testQ = new SimplePriorityQueue<Double>();

		testQ.insert(4.0);
		testQ.insert(6.0);
		testQ.insert(7.0);
		testQ.insert(5.0);
		testQ.insert(8.0);
		assertEquals(4.0, (double) testQ.findMin());
	}

	@Test
	public void insertDoubleTest() {
		SimplePriorityQueue<Double> testQ = new SimplePriorityQueue<Double>();

		testQ.insert(1.0);
		testQ.insert(2.0);
		assertEquals(2, testQ.size());
		testQ.deleteMin();
		assertEquals(1, testQ.size());
	}

	@Test
	public void findMinString() {
		assertEquals("12Stars", (String) strQueue.findMin());
	}

	@Test
	public void deleteMinString() {
		assertEquals("12Stars", (String) strQueue.deleteMin());
		assertEquals(2, strQueue.size());
	}

	@Test
	public void clearString() {
		doubleQueue.clear();
		assertThrows(NoSuchElementException.class, () -> {
			doubleQueue.findMin();
		});
	}

	@Test
	public void insertOrderTestString() {
		strQueue.clear();
		strQueue.insert("ooo");
		strQueue.insert("o");
		strQueue.insert("oo");
		assertEquals("o", (String) strQueue.findMin());
	}

	@Test
	public void insertTestString() {
		SimplePriorityQueue<String> testQ = new SimplePriorityQueue<String>();

		testQ.insert("ooooo");
		testQ.insert("ooo");
		testQ.insert("oooo");
		testQ.insert("oo");
		testQ.insert("o");
		assertEquals(5.0, testQ.size());
	}

	@Test
	public void findMinTestString2() {
		SimplePriorityQueue<String> testQ = new SimplePriorityQueue<String>();

		testQ.insert("ooooo");
		testQ.insert("ooo");
		testQ.insert("oooo");
		testQ.insert("oo");
		testQ.insert("o");
		assertEquals("o", (String) testQ.findMin());
	}

	@Test
	public void insertAllStringTest() {
		ArrayList<String> testQ = new ArrayList<>();
		SimplePriorityQueue<String> testP = new SimplePriorityQueue<String>();

		testQ.add("ooooo");
		testQ.add("ooo");
		testQ.add("oooo");
		testQ.add("oo");
		testQ.add("o");
		testP.insertAll(testQ);
		assertEquals(5.0, testP.size());
		assertEquals("o", testP.findMin());
	}

	@Test
	public void findMinGregorian() {
		assertEquals(new GregorianCalendar(1999, 5, 11), (GregorianCalendar) gcQ.findMin());
	}

	@Test
	public void deleteMinGregorian() {
		assertEquals(new GregorianCalendar(1999, 5, 11), (GregorianCalendar) gcQ.deleteMin());
		assertEquals(2, gcQ.size());
	}

	@Test
	public void clearGregorian() {
		gcQ.clear();
		assertThrows(NoSuchElementException.class, () -> {
			gcQ.findMin();
		});
	}

	@Test
	public void insertAllGregorianTest() {
		ArrayList<GregorianCalendar> testQ = new ArrayList<>();
		SimplePriorityQueue<GregorianCalendar> testP = new SimplePriorityQueue<GregorianCalendar>();

		GregorianCalendar d1 = new GregorianCalendar(1999, 5, 11);
		GregorianCalendar d3 = new GregorianCalendar(2013, 18, 9);
		GregorianCalendar d2 = new GregorianCalendar(2004, 25, 12);
		testQ.add(d1);
		testQ.add(d3);
		testQ.add(d2);
		testP.insertAll(testQ);
		assertEquals(3, testP.size());
		assertEquals(d1, testP.findMin());
	}

	@Test
	public void testLibrary() {
	}
}