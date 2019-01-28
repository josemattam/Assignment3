package assign03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimplePriorityQueueTest {

	@Test
	public void insertTest() {
		int[] arr1 = { 5, 6, 7 ,8 ,9 };
		double[] arr2 =  {5.0, 6.0, 7.0, 8.0, 9.0};
		long[] arr3 =  { 12345678, 12345679, 12345680};
		SimplePriorityQueue<Integer> q1 = new SimplePriorityQueue<>();
		q1.insertAll(arr1);
	}

}
