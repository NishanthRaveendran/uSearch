package uSearch;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReviewTest {

	@Test
	public void testReviewData() {
		Review review1 = new Review("R1", "guy1", "its good", 4.5, "15323", 52, "summary1");
		assertTrue(review1.getAsin().equals("R1"));
		assertTrue(review1.getReviewerName().equals("guy1"));
		assertTrue(review1.getReviewText().equals("its good"));
		assertTrue(review1.getReviewTime().equals("15323"));
		assertTrue(review1.getUnixTime() == 52);
		assertTrue(Math.abs(review1.getOverall() - 4.5) < 0.00001);
	}

	@Test
	public void testCompareASIN() {
		Review review1 = new Review("R1", "guy1", "its good", 4.5, "15323", 52, "summary1");
		Review review2 = new Review("R2", "guy1", "its good", 4.5, "15323", 52, "summary1");
		assertTrue(review1.compareAsin(review2) < 0);
		assertTrue(review2.compareAsin(review2) == 0);
		assertTrue(review2.compareAsin(review1) > 0);
	}
}