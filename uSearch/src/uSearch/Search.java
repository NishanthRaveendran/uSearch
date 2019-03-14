package uSearch;

/**
 * class containing binary search methods for Product ADT and Review ADT
 * 
 * @author Dananjay Prabaharan, 400128524, prabahad referenced from Algorithms,
 *         4th Edition by Robert Sedgewick and Kevin Wayne
 */

public class Search {
  
  /**
   * Returns the index of the asin value that needs to be searched in the array
   * 
   * @param asin - The product asin value that needs to be searched in the product array
   * @param a - The inputted product array
   */
  public static int searchProductAsin(String asin, Product[] a){ 
       int lo  = 0;
       int hi = a.length - 1;
       while (lo <= hi) {  
          int mid = lo + (hi - lo) / 2;
          if (asin.compareTo(a[mid].getAsin()) < 0) hi = mid - 1;
          else if (asin.compareTo(a[mid].getAsin()) > 0) lo = mid + 1;
          else return mid;
       }
       return -1; 
    }

  /**
   * Returns the index of the title value that needs to be searched in the array
   * 
   * @param title - The product title value that needs to be searched in the product array
   * @param a - The inputted product array
   */
  public static int searchProductTitle(String title, Product[] a){ 
      int lo  = 0;
      int hi = a.length - 1;
      while (lo <= hi) {  
         int mid = lo + (hi - lo) / 2;
         if (title.compareTo(a[mid].getTitle()) < 0) hi = mid - 1;
         else if (title.compareTo(a[mid].getTitle()) > 0) lo = mid + 1;
         else return mid;
      }
      return -1; 
  }

  /**
   * Returns the index of the group value that needs to be searched in the array
   * 
   * @param group - The product group value that needs to be searched in the product array
   * @param a - The inputted product array
   */
  public static int searchProductGroup(String group, Product[] a){ 
      int lo  = 0;
      int hi = a.length - 1;
      while (lo <= hi) {  
         int mid = lo + (hi - lo) / 2;
         if (group.compareTo(a[mid].getGroup()) < 0) hi = mid - 1;
         else if (group.compareTo(a[mid].getGroup()) > 0) lo = mid + 1;
         else return mid;
      }
      return -1; 
  }
  
  /**
   * Returns the index of the asin value that needs to be searched in the array
   * 
   * @param asin - The review asin value that needs to be searched in the product array
   * @param a - The inputted review array
   */
  public static int searchReviewAsin(String asin, Review[] a){ 
      int lo  = 0;
      int hi = a.length - 1;
      while (lo <= hi) {  
         int mid = lo + (hi - lo) / 2;
         if (asin.compareTo(a[mid].getAsin()) < 0) hi = mid - 1;
         else if (asin.compareTo(a[mid].getAsin()) > 0) lo = mid + 1;
         else return mid;
      }
      return -1; 
  } 
}
