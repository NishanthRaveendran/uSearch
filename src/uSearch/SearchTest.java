package uSearch;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchTest {

	String[] similar1 = { "Product1", "Product2" };
	Product P1 = new Product("P1", "Product2", "Book1", similar1, 2.5);
	Product P2 = new Product("P2", "Product3", "Book2", similar1, 3.5);
	Product P3 = new Product("P3", "Product4", "Book3", similar1, 4.5);
	Product P4 = new Product("P4", "Product5", "Book4", similar1, 5.5);

	Review R1 = new Review("P1", "Bob", "good", 5.5, "tuesday", 6, "d");
	Review R2 = new Review("P2", "Bob", "good", 5.5, "tuesday", 6, "d");
	Review R3 = new Review("P3", "Bob", "good", 5.5, "tuesday", 6, "d");
	Review R4 = new Review("P4", "Bob", "good", 5.5, "tuesday", 6, "d");
	
	Product[] LX = {P1,P2,P3,P4};
	Review[] RX = {R1,R2,R3,R4};
			
    @BeforeEach
    void setUp() throws Exception {
    }

	
	@Test
	void testSearchProductAsin() {
		int i = Search.searchProductAsin("P1", LX);
		assertTrue(i == 0);
		
	}
	
	@Test
	void testSearchProductTitle() {
		int i = Search.searchProductTitle("Product4", LX);
		assertTrue(i == 2);
	}
	
	@Test
	void testSearchProductGroup() {
		int i = Search.searchProductGroup("Book2", LX);
		assertTrue(i == 1);
	}
	
	@Test
	void testSearchReviewAsin() {
		int i = Search.searchReviewAsin("P4", RX);
		assertTrue(i == 3);
	}

}
