package uSearch;

public class App {

	public static void main(String[] args) throws Exception {		
		
		//Load Data
		String[] productstrings = Read.readData("data\\productdata2.txt", 542684);		
		String[] reviewstrings = Read.readData("data\\CDs_and_Vinyl_5.json", 1097592);
		
		//Create objects
		Product[] products = CreateItems.createProducts(productstrings);
		Review[] reviews = CreateItems.createReviews(reviewstrings);

				
		//ADD A LOADING GIF FOR APP HERE
		
		
		//APP is ready to use
		System.out.println("APP READY");	
		
		//WAIT FOR USER ASIN INPUT
		//Say user pick product with id "0307141985"
		
		//USE THE PRODUCTS ARRAY FROM ABOVE AND SEARCH FOR THE PRODUCT
		//USE THE PRODUCT PROPERTIES TO FILL IN THE STUFF LIKE ASIN, TITLE, ...
		
		
		//USE THIS AS A GUIDELINE TO EXTRACT THE REVIEWS FOR THE ASIN
		Review[] temp = {null, null, null};
		int j = 0;
		for(Review i : reviews) {
			if(i.getAsin().equals("0307141985")) {
				temp[j] = i;
				j++;				
			}
			if(j == 3) {
				break;
			}
		}		
		
		//USE THIS AS A GUIDELINE TO FILL IN THE REVIEWS (SOME PRODUCTS HAVE LESS THAN 3 REVIEWS, JUST DISPLAY TEXT NONE)
		for(Review k: temp) {
			if(k != null) {
				System.out.println("\""+ k.getReviewText() + "\"" + ", "+ k.getOverall());
			}else {
				System.out.println("None");		
			}				
		}
	}

}
