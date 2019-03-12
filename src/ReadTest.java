package uSearch;

import java.io.IOException;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testReadMetaData() throws Exception {
//		String[] temp = Read.readData("data\\productdata2.txt", 542684);
		String[] temp = Read.readData("data\\CDs_and_Vinyl_5.json", 1097592);
		System.out.println(temp[0]);
	}

}
