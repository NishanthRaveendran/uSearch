package uSearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReadTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	void testReadMetaData() throws Exception {
//		String[] temp = Read.readData("data\\productdata2.txt", 542684);
		String[] temp = Read.readData("data\\CDs_and_Vinyl_5.json", 1097592);
		System.out.println(temp[0]);
	}

}
