package uSearch;

import java.util.Scanner;

//Main command line app
public class CommandLineApp {

	public static void main(String[] args) throws Exception {		
		
		System.out.println("APP IS LOADING...(takes about 90 sec)");	
		
		//Load Data
		String[] productstrings = Read.readData("data\\productdata2.txt", 542684);		
		String[] reviewstrings = Read.readData("data\\CDs_and_Vinyl_5.json", 1097592);
		
		//Create objects
		Product[] products = CreateItems.createProducts(productstrings);
		Review[] reviews = CreateItems.createReviews(reviewstrings);				
		
		Sort.sortAsin(products, 542684);

		System.out.println("APP READY TO USE");	
		
		System.out.println("Type exit to quit");		
		
		//Main loop
		String input = "";
		Scanner reader = new Scanner(System.in);
		while(true) {
		
			//Sample product id "0307141985"
			//Sample product id "0827229534"
			System.out.println("Enter product asin");
			input = reader.next();		
			if (input.equals("exit")) break;
			
			int productloc = Search.searchProductAsin(input, products);
			if (productloc == -1) {
				System.out.println("Cannot find product");
				continue;
			}
			
			Graph digraph = new Graph(products, indexOfProduct(products, input));
			Product[] connected = digraph.connectedProducts(); 
			Sort.sortRating(connected, connected.length);
			
			System.out.println("---------------------------------------------------------------");
			
			//Display product information
			System.out.println("Product information");
			System.out.println("	" + products[productloc].toString());
			
			//Display product reviews
			System.out.println("Product reviews");			
			printReviews(reviews, input);
			
			//Display similar products
			System.out.println("Similar products");
			printAlternatives(connected);
			
			System.out.println("---------------------------------------------------------------");
		}
		
		reader.close();		
	}
	
	//Print similar products
	private static void printAlternatives(Product[] products) {
		String [] temp = {"None available","None available","None available"};
		int j = 0;
		for(int f = products.length - 1; f >= 0; f--) {
			temp[j] = products[f].toString();
			j++;				
			if(j == 3) {
				break;
			}
		}
		for(String s : temp) {
			System.out.println("	" + s);
		}
	}
	
	//Print reviews
	private static void printReviews(Review[] reviews, String input) {
		String[] temp = {"None available", "None available", "None available"};
		int j = 0;
		for(int f = 0; f < reviews.length; f++) {
			if(reviews[f].getAsin().equals(input)) {
				temp[j] = reviews[f].toString();
				j++;				
			}
			if(j == 3) {
				break;
			}
		}
		for(String s : temp) {
			System.out.println("	" + s);
		}
	}
	
	//Get index of a product using the product asin
	private static int indexOfProduct(Product[] products, String asin) {
		for(int i = 0; i < products.length; i++) {
			if(products[i].getAsin().equals(asin)) return i;
		}
		return -1;
	}
}