package uSearch;

/**
 * class containing top down and bottom up merge sorts, and helper methods
 * 
 * @author Nishanth Raveendran, 400121953, raveendn referenced from Algorithms,
 *         4th Edition by Robert Sedgewick and Kevin Wayne
 */
public class Sort {
	private static Product[] aux;

	/**
	 * bottom-up merge sort using Comparable
	 * 
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortAsin(Product[] x, int n) {
		aux = new Product[n];
		for (int size = 1; size < n; size = size + size)
			for (int low = 0; low < n - size; low += size + size)
				merge(x, low, low + size - 1, Math.min(low + size + size - 1, n - 1), 'A');
	}

	public static void sortTitle(Product[] x, int n) {
		aux = new Product[n];
		for (int size = 1; size < n; size = size + size)
			for (int low = 0; low < n - size; low += size + size)
				merge(x, low, low + size - 1, Math.min(low + size + size - 1, n - 1), 'T');
	}

	public static void sortRating(Product[] x, int n) {
		aux = new Product[n];
		for (int size = 1; size < n; size = size + size)
			for (int low = 0; low < n - size; low += size + size)
				merge(x, low, low + size - 1, Math.min(low + size + size - 1, n - 1), 'R');
	}

	/**
	 * merges partitions for mergesort
	 * 
	 * @param x      - the input array containing products that need to be sorted
	 * @param low    - low index
	 * @param middle - middle index
	 * @param high   - high index
	 */
	private static void merge(Product[] x, int low, int middle, int high, char type) {
		int left = low, right = middle + 1;

		for (int i = low; i <= high; i++) {
			aux[i] = x[i];
		}

		for (int i = low; i <= high; i++) {
			if (left > middle)
				x[i] = aux[right++];
			else if (right > high)
				x[i] = aux[left++];
			else if (type == 'A' && aux[right].compareAsin(aux[left]) < 0)
				x[i] = aux[right++];
			else if (type == 'T' && aux[right].compareTitle(aux[left]) < 0)
				x[i] = aux[right++];
			else if (type == 'R' && aux[right].compareRating(aux[left]) < 0)
				x[i] = aux[right++];
			else
				x[i] = aux[left++];
		}
	}
}
