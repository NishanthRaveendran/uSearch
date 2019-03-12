package uSearch;

/**
 * Product is an abstract data type representing a product. An instance of this
 * type will have a title, asin, group, list of similar products and it's
 * average rating.
 */
public class Product {
	private String asin;
	private String title;
	private String group;
	private String[] similar;
	private double rating;

	/**
	 * Used to construct an instance of Product.
	 * 
	 * @param asin String product id (asin)
	 * @param title String title of the product
	 * @param group String group of the product
	 * @param similar List of Strings similar products
	 * @param rating Double product rating	
	 */
	public Product(String asin, String title, String group, String[] similar, double rating) {
		this.asin = asin;
		this.title = title;
		this.group = group;
		this.similar = similar;
		this.rating = rating;

	}

	/**
	 * Used to get the asin of the product.
	 * 
	 * @return Returns asin
	 */
	public String getAsin() {
		return this.asin;
	}

	/**
	 * Used to get the title of the product
	 * 
	 * @return Returns title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Used to get the group of the product
	 * 
	 * @return Returns group
	 */
	public String getGroup() {
		return this.group;
	}

	/**
	 * Used to get the list of similar products
	 * 
	 * @return Returns similar
	 */
	public String[] getSimilar() {
		return this.similar;
	}

	/**
	 * Used to get the rating of the product
	 * 
	 * @return Returns rating
	 */
	public double getRating() {
		return this.rating;
	}

	/**
	 * Used to get the string representation of the product
	 * 
	 * @return Returns asin with the label 'Asin'
	 */
	@Override
	public String toString() {
		return String.format("Asin: %s", asin);
	}

	/**
	 * Used to compare this product to another product by their asin
	 * 
	 * @param that Other instance of the product that will be compared
	 * @return -1 if this product's asin is less than the passed in product's asin
	 * 			1 if this product's asin is greater than the passed in product's asin
	 * 			0 if this product's asin is equal to the passed in product's asin
	 */
	public int compareAsin(Product that) {
		if (this.asin.compareTo(that.getAsin()) < 0)
			return -1;
		if (this.asin.compareTo(that.getAsin()) > 0)
			return 1;
		return 0;
	}

	/**
	 * Used to compare this product to another product by their title
	 * 
	 * @param that Other instance of the product that will be compared
	 * @return -1 if this product's title is less than the passed in product's title, 
	 * 			1 if this product's title is greater than the passed in product's title, 
	 * 			result of the comparison by asin
	 */
	public int compareTitle(Product that) {
		if (this.title.compareTo(that.getTitle()) < 0)
			return -1;
		if (this.title.compareTo(that.getTitle()) > 0)
			return 1;
		return compareAsin(that);
	}

	/**
	 * Used to compare this product to another product by their rating
	 * 
	 * @param that Other instance of the product that will be compared
	 * @return -1 if this product's rating is less than the passed in product's rating, 
	 * 			1 if this product's rating is greater than the passed in product's rating, 
	 * 			result of the comparison by asin
	 */
	public int compareRating(Product that) {
		if (this.rating < that.getRating())
			return -1;
		if (this.rating > that.getRating())
			return 1;
		return compareAsin(that);
	}
}
