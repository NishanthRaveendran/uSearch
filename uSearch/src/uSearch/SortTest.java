package uSearch;

import static org.junit.Assert.*;
import org.junit.Test;

public class SortTest {

	/**
     * verifies if Product is less than one compared to
     * @param v - first Product comparable
     * @param w - second Product comparable
     * @return - boolean True if v is less than w
     */
	private static boolean less(Product v, Product w, char type) {
		if (type == 'A') return v.compareAsin(w) < 0; 
		else if (type == 'T') return v.compareTitle(w) < 0;
		else return v.compareRating(w) < 0;
	}
	
	/**
	 * verifies if an array of products is sorted 
	 * @param a - the input array containing products
	 * @return - boolean True if sorted, False if not
	 */
	public static boolean isSorted(Product[] a, char type) { // Test whether the array entries are in order.
		 for (int i = 1; i < a.length; i++)
			 if (less(a[i], a[i-1], type)) return false;
		 return true;
	}

	String[] similar1 = { "Product1", "Product2" };
	Product P1 = new Product("P1", "Product2", "Book", similar1, 9.5);
	Product P2 = new Product("P5", "Product4", "Book", similar1, 8.5);
	Product P3 = new Product("P3", "Product0", "Book", similar1, 5.5);
	Product P4 = new Product("P0", "Product3", "Book", similar1, 4.5);
	
	Product[] L1 = {P1,P2,P3,P4};
	Product[] L2 = {P1,P2,P3,P4};
	Product[] L3 = {P1,P2,P3,P4};
	
	@Test
	public void testSortAsin() {
		Sort.sortAsin(L2, 4);
		assertTrue(isSorted(L2, 'A'));
	}
	
	@Test
	public void testSortTitle() {
		Sort.sortTitle(L2, 4);
		assertTrue(isSorted(L2, 'T'));
	}
	
	@Test
	public void testSortRating() {
		Sort.sortRating(L3, 4);
		assertTrue(isSorted(L3, 'R'));
	}
}