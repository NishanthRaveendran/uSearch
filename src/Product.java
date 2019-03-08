package uSearch;

/**
 * Product is an abstract data type representing a product. An instance of this
 * type will have a title, asin, group, list of similar products and it's
 * average rating.
 */
public class Product {
	private int asin;
	private String title;
	private String group;
	private int[] similar;
	private double rating;

	/**
	 * Used to construct an instance of Product.
	 * 
	 * @param asin Integer product id (asin)
	 * @param title String title of the product
	 * @param group String group of the product
	 * @param similar List of Integer similar products
	 * @param rating Double product rating	
	 */
	public Product(int asin, String title, String group, int[] similar, double rating) {
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
	public int getAsin() {
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
	public int[] getSimilar() {
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
		return String.format("Asin: %d", asin);
	}

	/**
	 * Used to compare this product to another Product by their asin
	 * 
	 * @param that Other instance of the Product that will be compared
	 * @return -1 if this product's asin is less than the passed in product's asin
	 * 			1 if this product's asin is greater than the passed in product's asin
	 * 			0 if this product's asin is equal to the passed in product's asin
	 */
	public int compareAsin(Product that) {
		if (this.asin < that.getAsin())
			return -1;
		if (this.asin > that.getAsin())
			return 1;
		return 0;
	}

	/**
	 * Used to compare this product to another Product by their title
	 * 
	 * @param that Other instance of the Product that will be compared
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
	 * Used to compare this product to another Product by their rating
	 * 
	 * @param that Other instance of the Product that will be compared
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
