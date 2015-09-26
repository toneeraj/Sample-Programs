import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

//An iterative Fibonacci Sequence
public class TestFibonaci {

	public static List<Integer> fibonacci(int n) {

		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than 0");
		}

		if (n == 0) {
			return new ArrayList<>();
		}

		if (n == 1) {
			return Arrays.asList(0);
		}

		if (n == 2) {
			return Arrays.asList(0, 1);
		}

		final List<Integer> seq = new ArrayList<>(n);

		seq.add(0);
		n = n - 1;

		seq.add(1);
		n = n - 1;

		while (n > 0) {
			int size = seq.size();
			int newElement = seq.get(size - 1) + seq.get(size - 2);
			seq.add(newElement);
			n = n - 1;
		}

		return seq;
	}

	@Test
	public void fibList() {
		assertEquals(0, fibonacci(0).size());
		assertEquals(Arrays.asList(0), fibonacci(1));
		assertEquals(Arrays.asList(0, 1), fibonacci(2));
		assertEquals(Arrays.asList(0, 1, 1), fibonacci(3));
		assertEquals(Arrays.asList(0, 1, 1, 2), fibonacci(4));
		assertEquals(Arrays.asList(0, 1, 1, 2, 3), fibonacci(5));
		assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13), fibonacci(8));
		
	

	}
}
