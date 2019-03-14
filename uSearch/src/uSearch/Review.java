package uSearch;

/**
 * Product is an abstract data type representing a product. An instance of this
 * type will have a title, asin, group, list of similar products and it's
 * average rating.
 */
public class Review {
	private String asin;
	private String reviewerName;
	private String reviewText;
	private String reviewTime;
	private String summary;
	private int unixTime;
	private double overall;

	/**
	 * Used to construct an instance of Product.
	 * 
	 * @param asin String product id (asin)
	 * @param title String title of the product
	 * @param group String group of the product
	 * @param similar List of Strings similar products
	 * @param rating Double product rating	
	 */
	public Review(String asin, String reviewerName, String reviewText, double overall, String reviewTime, int unixTime, String summary) {
		this.asin = asin;
		this.reviewerName = reviewerName;
		this.reviewText = reviewText;
		this.overall = overall;
		this.reviewTime = reviewTime;
		this.unixTime = unixTime;
		this.summary = summary;
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
	public String getReviewerName() {
		return this.reviewerName;
	}

	/**
	 * Used to get the group of the product
	 * 
	 * @return Returns group
	 */
	public String getReviewText() {
		return this.reviewText;
	}

	/**
	 * Used to get the list of similar products
	 * 
	 * @return Returns similar
	 */
	public String getReviewTime() {
		return this.reviewTime;
	}
	
	/**
	 * Used to get the list of similar products
	 * 
	 * @return Returns similar
	 */
	public int getUnixTime() {
		return this.unixTime;
	}
	
	/**
	 * Used to get the list of similar products
	 * 
	 * @return Returns similar
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * Used to get the rating of the product
	 * 
	 * @return Returns rating
	 */
	public double getOverall() {
		return this.overall;
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
	public int compareAsin(Review that) {
		if (this.asin.compareTo(that.getAsin()) < 0)
			return -1;
		if (this.asin.compareTo(that.getAsin()) > 0)
			return 1;
		return 0;
	}
}
