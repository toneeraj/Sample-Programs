import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CachedFibSoultion {

	public static int fibN(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}
		if (n == 1)
			return 1;
		if (n == 0)
			return 0;
		return (fibN(n - 1) + fibN(n - 2));
	}

	// -----------------------------

	private Map<Integer, Integer> fibCache = new HashMap<>();

	public int cachedFibN(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}
		fibCache.put(0, 0);
		fibCache.put(1, 1);
		return recursiveCachedFibN(n);
	}

	private int recursiveCachedFibN(int n) {
		if (fibCache.containsKey(n)) {
			return fibCache.get(n);
		}
		int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
		fibCache.put(n, value);
		return value;
	}

	// ----------------------------------

	@Test
	public void largeFib() {
		final long nonCachedStart = System.nanoTime();
		assertEquals(1134903170, fibN(45));
		final long nonCachedFinish = System.nanoTime();
		assertEquals(1134903170, cachedFibN(45));
		final long cachedFinish = System.nanoTime();
		System.out.printf("Non cached time: %d nanoseconds%n", nonCachedFinish
				- nonCachedStart);
		System.out.printf("Cached time: %d nanoseconds%n", cachedFinish
				- nonCachedFinish);
	}
}
