package uSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Library of functions to read the file and produce a list of strings
 */
public class Read {
	
	/**
	 * Used to read a string of data line by line 
	 * 
	 * @param path String path to the file with data 
	 * @param size int size of the dataset (number of rows)
	 * @return List of strings extracted from the file
	 */
	public static String[] readData(String path, int size) throws Exception {
		String[] products = new String[size];

		try {
			File fileDir = new File(path);
				
			BufferedReader in = new BufferedReader(
			   new InputStreamReader(
	                      new FileInputStream(fileDir), "UTF8"));
			int index = 0;   
			String str;
			      
			while ((str = in.readLine()) != null) {
			    products[index++] = str;
			}			        
	                in.close();
		    } 
		    catch (UnsupportedEncodingException e) 
		    {
				System.out.println(e.getMessage());
		    } 
		    catch (IOException e) 
		    {
				System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    }
	
		return products;
	}	
}