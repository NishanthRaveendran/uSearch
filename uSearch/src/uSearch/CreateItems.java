package uSearch;

/**
 * Library of functions to create corresponding items used in the program from a
 * list describing it.
 */
public class CreateItems {

	/**
	 * Used to create products from list of strings take from data set.
	 * 
	 * @param productString List of strings of product data
	 * @return List of products made from list of strings
	 */
	public static Product[] createProducts(String[] productstring) {
		Product[] products = new Product[productstring.length];

		for (int j = 0; j < products.length; j++) {
			String[] tempsplit1 = productstring[j].split(", group:");

			String[] leftsplit = tempsplit1[0].split(", title:");
			String[] leftleftsplit = leftsplit[0].split(":");
			String asin = leftleftsplit[1].strip();

			String title = leftsplit[1].strip();

			String[] tempsplit = tempsplit1[1].split(":");
			String[] tempsplit2 = tempsplit[0].split(",");
			String group = tempsplit2[0].strip();

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

			products[j] = new Product(asin, title, group, similar, rating);
		}

		return products;
	}

	/**
	 * Used to create reviews from list of strings take from data set.
	 * 
	 * @param productString List of strings of review data
	 * @return List of reviews made from list of strings
	 */
	public static Review[] createReviews(String[] reviewstring) {
		Review[] reviews = new Review[reviewstring.length];

		for (int j = 0; j < reviewstring.length; j++) {

			String[] tempsplit1 = reviewstring[j].split(", \"reviewText\":");

			String[] tempsplit = tempsplit1[0].split(":");
			String[] tempsplit2 = tempsplit[2].split(",");
			String asin = tempsplit2[0].replaceAll("\"", "").strip();

			tempsplit2 = tempsplit[3].split(",");
			String reviewerName = tempsplit2[0].replaceAll("\"", "").strip();

			String[] rightsplit = tempsplit1[1].split(", \"summary\":");
			String[] leftsplit = rightsplit[0].split(", \"overall\":");

			String reviewText = leftsplit[0].replaceAll("\"", "").strip();

			double overall = Double.parseDouble(leftsplit[1].replaceAll("\"", "").strip());

			String[] rightrightsplit = rightsplit[1].split(", \"unixReviewTime\":");
			String summary = rightrightsplit[0].replaceAll("\"", "").strip();

			tempsplit2 = rightrightsplit[1].split(", \"reviewTime\":");
			int unixTime = Integer.parseInt(tempsplit2[0].replaceAll("\"", "").strip());

			String temp = tempsplit2[1].replaceAll("}", "").strip();
			String reviewTime = temp.replaceAll("\"", "").strip();

			reviews[j] = new Review(asin, reviewerName, reviewText, overall, reviewTime, unixTime, summary);
		}

		return reviews;
	}
}