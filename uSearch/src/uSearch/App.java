package uSearch;

import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {		
		
		//APP is loading
		System.out.println("APP IS LOADING...");	
		
		//Load Data
		String[] productstrings = Read.readData("data\\productdata2.txt", 542684);		
		String[] reviewstrings = Read.readData("data\\CDs_and_Vinyl_5.json", 1097592);
		
		//Create objects
		Product[] products = CreateItems.createProducts(productstrings);
		Review[] reviews = CreateItems.createReviews(reviewstrings);				
		
		//ADD A LOADING GIF FOR APP HERE			

		
//		System.out.println(products[0].getAsin());
		Sort.sortAsin(products, 542684);
//		System.out.println(products[0].getAsin());
		
//		int[] reviewindex = {-1, -1, -1};
		
//		int revstart = Search.searchReviewAsin("0307141985", reviews);
//		System.out.println(revstart);
		
		
		//APP is ready to use
		System.out.println("APP READY TO USE");	
		
		System.out.println("Type exit to quit");
		
		String input = "";
		Scanner reader = new Scanner(System.in);
		while(true) {
		
			System.out.println("Enter product asin");
			input = reader.next();		
			if (input.equals("exit")) break;			
			int productloc = Search.searchProductAsin(input, products);
			if (productloc == -1) {
				System.out.println("Cannot find product");
				continue;
			}
			System.out.println("PRODUCT INFO");
			System.out.println(products[productloc].toString());
			//WAIT FOR USER ASIN INPUT
			//Say user pick product with id "0307141985"
			
			//USE THE PRODUCTS ARRAY FROM ABOVE AND SEARCH FOR THE PRODUCT
			//USE THE PRODUCT PROPERTIES TO FILL IN THE STUFF LIKE ASIN, TITLE, ...
			
			
			//USE THIS AS A GUIDELINE TO EXTRACT THE REVIEWS FOR THE ASIN
			int [] temp = {-1,-1,-1};
			int j = 0;
			for(int f = 0; f < reviews.length; f++) {
				if(reviews[f].getAsin().equals(input)) {
					temp[j] = f;
					j++;				
				}
				if(j == 3) {
					break;
				}
			}		
			
			System.out.println("REVIEWS");
			//USE THIS AS A GUIDELINE TO FILL IN THE REVIEWS (SOME PRODUCTS HAVE LESS THAN 3 REVIEWS, JUST DISPLAY TEXT NONE)
			for(int k: temp) {
				if(k != -1) {
					System.out.println( reviews[k].getAsin()+ " " + "\""+ reviews[k].getSummary() + "\"" + ", "+ reviews[k].getOverall());
				}else {
					System.out.println("None");		
				}				
			}
		}
		
		reader.close();
		
	}

}
