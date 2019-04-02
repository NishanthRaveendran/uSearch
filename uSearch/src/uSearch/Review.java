package uSearch;

/**
 * Review is an abstract data type representing a product review. An instance of this
 * type will have a reviewer name, review text, review summary, review time, review's unix time,
 * reviewer's rating of the product and the product asin.
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
	 * Used to construct an instance of Review.
	 * 
	 * @param asin String product id (asin)
	 * @param reviewerName String reviewer's name
	 * @param reviewText String review text
	 * @param overall double reviewer's rating of the product
	 * @param reviewTime String review time	
	 * @param unixTime int review's unix time	
	 * @param reviewSummary String review summary
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
	 * Used to get the asin of the review.
	 * 
	 * @return Returns asin
	 */
	public String getAsin() {
		return this.asin;
	}

	/**
	 * Used to get the reviewer's name 
	 * @return Returns reviewerName
	 */
	public String getReviewerName() {
		return this.reviewerName;
	}

	/**
	 * Used to get the text of the review
	 * 
	 * @return Returns reviewText
	 */
	public String getReviewText() {
		return this.reviewText;
	}

	/**
	 * Used to get the time of the review
	 * 
	 * @return Returns reviewTime
	 */
	public String getReviewTime() {
		return this.reviewTime;
	}
	
	/**
	 * Used to get the unix time of the review
	 * 
	 * @return Returns unixTime
	 */
	public int getUnixTime() {
		return this.unixTime;
	}
	
	/**
	 * Used to get the summary of the review
	 * 
	 * @return Returns summary
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * Used to get the reviewer's rating of the product
	 * 
	 * @return Returns overall
	 */
	public double getOverall() {
		return this.overall;
	}

	/**
	 * Used to get the string representation of the review
	 * 
	 * @return Returns asin, summary and overall with the labels
	 */
	@Override
	public String toString() {
		return String.format("Asin: %s, Summary: %s, Rating: %s", asin, summary, overall);
	}

	/**
	 * Used to compare this review to another review by their asin
	 * 
	 * @param that Other instance of the review that will be compared
	 * @return -1 if this review's asin is less than the passed in review's asin
	 * 			1 if this review's asin is greater than the passed in review's asin
	 * 			0 if this review's asin is equal to the passed in review's asin
	 */
	public int compareAsin(Review that) {
		if (this.asin.compareTo(that.getAsin()) < 0)
			return -1;
		if (this.asin.compareTo(that.getAsin()) > 0)
			return 1;
		return 0;
	}
}