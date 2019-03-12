package uSearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateItemsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

//	@Test
//	void testCreateProducts() {
//		String[] temp = {
//				"ASIN: 0878148418, title: Fireground Strategies Scenario Workbook, group: Book, similar: 4  0878149023  0787939897  0912212845  087814840X, avg rating: 0",
//				"ASIN: 0816748209, title: Double-Cross Mazes, group: Book, similar: 0, avg rating: 0"				
//		};
//		Product[] test1 = CreateItems.createProducts(temp);		
//		assertTrue(test1[0].getAsin().equals("0878148418"));		
//		assertTrue(test1[0].getTitle().equals("Fireground Strategies Scenario Workbook"));
//		assertTrue(test1[0].getGroup().equals("Book"));		
//		if(test1[0].getSimilar() != null) {
//			for (String i : test1[0].getSimilar()) {			
//				assertTrue(i.equals("0878149023") || i.equals("0787939897") || i.equals("0912212845") || i.equals("087814840X"));						
//			}			
//		}		
//		assertTrue(Math.abs(test1[0].getRating() - 0.0) < 0.00001);
//	}
	
	@Test
	void testCreateReviews() {
		String[] temp = {
				"{\"reviewerID\": \"A3IEV6R2B7VW5Z\", \"asin\": \"0307141985\", \"reviewerName\": \"J. Anderson\", \"helpful\": [14, 15], \"reviewText\": \"I don't know who owns the rights to this wonderful production, but considering all the other Rankin/Bass goodies available on DVD, why has Mouse On The Mayflower been ignored for release? It's ludacris! Release it!! For heaven's sake!! This production deserves at least the same repect that was given to lesser productions like \\\"Rudoloph's Shiny New Year\\\" or \\\"The Little Drummer Boy, Book II\\\", which were not half as good as Mouse On The Mayflower\\\". Most of us Baby Boomers grew up with this stuff. We got our baths & teeth brushed early so we could watch them before being scurried off to bed, and anxiously awaited repeats year after year. Did anyone else but me sit with a cassette recorder next to the TV speaker so they could record the show audio? LOL. I did. I loved the songs, and I'd listen to the tapes I made and play the visuals over and over in my head. God it was great being a kid! C'Mon Rankin/Bass! Bring this one back on DVD! It's a classic!\", \"overall\": 5.0, \"summary\": \"LISTEN TO THE PUBLIC!!!\", \"unixReviewTime\": 1128556800, \"reviewTime\": \"10 6, 2005\"}",
				"{\"reviewerID\": \"A2H3ISQ4QB95XN\", \"asin\": \"0307141985\", \"reviewerName\": \"Joseph Brando\", \"helpful\": [2, 2], \"reviewText\": \"Thanksgiving is devoid of icons to make it a favorite amoung children - Tom Turkey can't compete with Santa Claus or Dracula - and so this holiday which is crammed in between the other two bigger ones comes up short when it comes to fun TV specials marking the celebration. However, you can count on Rankin/Bass, the long-reigning kings of enchanted holiday programming, to have left us this warm, entertaining show.Treading a fine line between historical accuracy and cartoon make-believe, Mouse On The Mayflower tells the tale of the Pilgrims' toilsome trip over to Plymouth Rock from the perspective of its tiniest passenger - a mouse! Although this special was done in traditional animation, and not the charming Animagic puppet-animation the studio is most well-known for, it still bears all of the trademarks of a Rankin/Bass special - with that bouncy background music that gets you all hyped up for the holiday. Also, like most other R/B specials, this one gets better and better each year you view it, with the songs becoming more familiar and enjoyable every time.With the lack of Thanksgiving Day Specials out there, and the beloved legend-like status of Rankin/Bass, you would think that this one would have been released on DVD a long time - but not the case! We are still left with a decade-old VHS release as our only source. Hopefully this will change soon.\", \"overall\": 4.0, \"summary\": \"Rankin/Bass Does Thanksgiving!!\", \"unixReviewTime\": 1322006400, \"reviewTime\": \"11 23, 2011\"}"				
		};
		
		Review[] test1 = CreateItems.createReviews(temp);
		assertTrue(test1[0].getAsin().contentEquals("0307141985"));
		assertTrue(test1[0].getReviewerName().equals("J. Anderson"));
		assertTrue(test1[0].getReviewText().equals("I don't know who owns the rights to this wonderful production, but considering all the other Rankin/Bass goodies available on DVD, why has Mouse On The Mayflower been ignored for release? It's ludacris! Release it!! For heaven's sake!! This production deserves at least the same repect that was given to lesser productions like \\Rudoloph's Shiny New Year\\ or \\The Little Drummer Boy, Book II\\, which were not half as good as Mouse On The Mayflower\\. Most of us Baby Boomers grew up with this stuff. We got our baths & teeth brushed early so we could watch them before being scurried off to bed, and anxiously awaited repeats year after year. Did anyone else but me sit with a cassette recorder next to the TV speaker so they could record the show audio? LOL. I did. I loved the songs, and I'd listen to the tapes I made and play the visuals over and over in my head. God it was great being a kid! C'Mon Rankin/Bass! Bring this one back on DVD! It's a classic!"));
		assertTrue(Math.abs(test1[0].getOverall() - 5.0) < 0.00001);
		assertTrue(test1[0].getSummary().contentEquals("LISTEN TO THE PUBLIC!!!"));
		assertTrue(test1[0].getUnixTime() == 1128556800);
		assertTrue(test1[0].getReviewTime().equals("10 6, 2005"));
	}

}
