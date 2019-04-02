package uSearch;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReadTest {

	@Test
	public void testReadData() throws Exception {
		String[] productData = Read.readData("data\\productdata2.txt", 542684);		
		String[] reviewData = Read.readData("data\\CDs_and_Vinyl_5.json", 1097592);
		assertTrue(productData[0].contains("0827229534"));
		assertTrue(reviewData[0].contains("0307141985"));
	}
}