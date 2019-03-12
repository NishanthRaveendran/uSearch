package uSearch;

import java.util.Arrays;

public class CreateItems {
	public static Product[] createProducts(String[] productstring) {
		Product[] products = new Product[productstring.length];

		for (int j = 0; j < products.length; j++) {
			String[] tempsplit1 = productstring[j].split(", group:");
			
			String[] leftsplit = tempsplit1[0].split(", title:");
			String[] leftleftsplit = leftsplit[0].split(":");	
			String asin = leftleftsplit[1].strip();
			
			String title = leftsplit[1].strip();

//			tempsplit2 = tempsplit[2].split(", grou");			
//			String title = tempsplit2[0].strip();
			
//			tempsplit2 = tempsplit[3].split(",");
//			String group = tempsplit2[0].strip();
	
			
//			tempsplit2 = tempsplit[1].split(":");
//			String title = tempsplit2[1].strip();
//			String title = "f";

			String[] tempsplit = tempsplit1[1].split(":");		
			String[] tempsplit2 = tempsplit[0].split(",");
			String group = tempsplit2[0].strip();
			
			
//			tempsplit2 = tempsplit[2].split(":");
//			String group = tempsplit2[1].strip();
//			String group = "missing books";

			tempsplit2 = tempsplit[1].split(",");
			String[] similar = null;
			String[] testnull = tempsplit2[0].split("  ");
			
			if (Integer.parseInt(testnull[0].strip()) != 0) {			
				similar = new String[testnull.length - 1];
				for (int i = 1; i < testnull.length; i++) {
					similar[i - 1] = testnull[i];		
				}
			}		
			
			double rating = Double.parseDouble((tempsplit[2].strip()));

//			String title = "tlt";
//			String group = "Book";
//			String[] similar = {"gf", "gfg"};
//			double rating = 5.3;
			products[j] = new Product(asin, title, group, similar, rating);
		}

		return products;
	}

	public static Review[] createReviews(String[] reviewstring) {
		Review[] reviews = new Review[reviewstring.length];

		for (int j = 0; j < reviewstring.length; j++) {
			
			String[] tempsplit1 = reviewstring[j].split(", \"reviewText\":");
			
//			String[] leftsplit = tempsplit1[0].split(":");
//			String[] leftleftsplit = leftsplit[0].split(":");	
//			String asin = leftleftsplit[1].strip();
//			
//			String title = leftsplit[1].strip();
			
			///////////
			
			String[] tempsplit = tempsplit1[0].split(":");
			String[] tempsplit2 = tempsplit[2].split(",");
			String asin = tempsplit2[0].replaceAll("\"", "").strip();


			tempsplit2 = tempsplit[3].split(",");
			String reviewerName = tempsplit2[0].replaceAll("\"", "").strip();

//			String reviewerName = "fdfd";

			String[] rightsplit = tempsplit1[1].split(", \"summary\":");
			String[] leftsplit = rightsplit[0].split(", \"overall\":");	
			
			String reviewText = leftsplit[0].replaceAll("\"", "").strip();
//			System.out.println(reviewText);
//			String reviewText = "dds";

//			tempsplit2 = tempsplit[6].split(",");
			double overall = Double.parseDouble(leftsplit[1].replaceAll("\"", "").strip());
//			double overall = 5.6;

//			tempsplit2 = tempsplit[7].split(", \\\"u");
			String[] rightrightsplit = rightsplit[1].split(", \"unixReviewTime\":");	
			String summary = rightrightsplit[0].replaceAll("\"", "").strip();		
//			String summary = "fdfd";

			tempsplit2 = rightrightsplit[1].split(", \"reviewTime\":");
			int unixTime = Integer.parseInt(tempsplit2[0].replaceAll("\"", "").strip());			
//			int unixTime = 4343;				

			String temp = tempsplit2[1].replaceAll("}", "").strip();
			String reviewTime = temp.replaceAll("\"", "").strip();		
//			String reviewTime = "dfdsf";

			reviews[j] = new Review(asin, reviewerName, reviewText, overall, reviewTime, unixTime, summary);
		}
		
		return reviews;
	}
}
