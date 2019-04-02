package uSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * class representing a graph of connection between a source product.
 */
public class Graph {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int sourceIndex;
	private Product[] products;
	private int max;
	
	/**
	 * Used to create connected graph for a source product 
	 * 
	 * @param products List of products 
	 * @param sourceIndex Index of the source product 
	 */
	public Graph(Product[] products, int sourceIndex) {
		marked = new boolean[products.length];
		edgeTo = new int[products.length];
		this.sourceIndex = sourceIndex;
		this.products = products;
		this.max = 10;
		bfs(sourceIndex);
	}
	
	/**
	 * Used to get connected products to the source product
	 * 
	 * @return List of connected products
	 */
	public Product[] connectedProducts(){
		ArrayList<Product> connected = new ArrayList<Product>();
		for(int i = 0; i < marked.length; i++) {
			if(marked[i]) connected.add(this.products[i]);
		}		
		return connected.toArray(new Product[connected.size()]);
	}
	
	//Implementation of the bfs
	private void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();;
		marked[s] = true;
		queue.add(s);
		while(!queue.isEmpty() && this.max > 0) {
			int v = queue.remove();
			this.max -= 1;
			if(this.products[v].getSimilar() == null) continue;
			for(String w : this.products[v].getSimilar()) {
				int indexW = indexOfProduct(this.products, w);
				if(indexW != -1) {
					if(!marked[indexW]) {
						edgeTo[indexW] = v;
						marked[indexW] = true;
						queue.add(indexW);
					}
				}
			}	
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