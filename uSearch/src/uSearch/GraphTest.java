package uSearch;

import static org.junit.Assert.*;
import org.junit.Test;

public class GraphTest {

	@Test
	public void testGraph() throws Exception {
		String[] productstrings = Read.readData("data\\productdata2.txt", 542684);
		Product[] products = CreateItems.createProducts(productstrings);
		Graph digraph = new Graph(products, 0);
		Product[] temp = digraph.connectedProducts(); 
		assertTrue(temp[0].getAsin().equals("0827229534"));
		assertTrue(temp[1].getAsin().equals("0664222641"));
		assertTrue(temp[2].getAsin().equals("0801020867"));
	}
}