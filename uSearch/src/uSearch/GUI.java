import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	private JFrame frame;
	private JTextField productTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() throws Exception{
		initialize();
		
	}
	
	private static String[] printReviews(Review[] reviews, String input) {
		String[] temp = {"None available", "None available", "None available"};
		int j = 0;
		for(int f = 0; f < reviews.length; f++) {
			if(reviews[f].getAsin().equals(input)) {
				temp[j] = reviews[f].toString();
				j++;				
			}
			if(j == 3) {
				break;
			}
		}
//		for(String s : temp) {
//			System.out.println("	" + s);
//		}
		return temp;
	}
	
	private static int indexOfProduct(Product[] products, String asin) {
		for(int i = 0; i < products.length; i++) {
			if(products[i].getAsin().equals(asin)) return i;
		}
		return -1;
	}
	
	private static String[] printAlternatives(Product[] products) {
		String [] temp = {"None available","None available","None available"};
		int j = 0;
		for(int f = products.length - 1; f >= 0; f--) {
			temp[j] = products[f].toString();
			j++;				
			if(j == 3) {
				break;
			}
		}
		return temp;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception{
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 593);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] productstrings = Read.readData("data/productdata2.txt", 542684);
		String[] reviewstrings = Read.readData("data/CDs_and_Vinyl_5.json", 1097592);
		Product[] products = CreateItems.createProducts(productstrings);
		Review[] reviews = CreateItems.createReviews(reviewstrings);
		Sort.sortAsin(products, 542684);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 48, 82, 0, 130, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 30, 26, 29, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
//		JButton btnGo = new JButton("GO!");
//		btnGo.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
////				Sort.sortAsin(products, 542684);
//				int index = Search.searchProductAsin(productTF.getText(), products);
//				String[] temp = printReviews(reviews, productTF.getText());
//				
////				lblAsintext.setText(Integer.toString(index));
//				
//				lblProduct.setVisible(true);
//				lblAsin.setVisible(true);
//				
//				
//				lblReview.setVisible(true);
//				lblReview1.setVisible(true);
//				lblReview2.setVisible(true);
//				lblReview3.setVisible(true);
//				lblSuggestions.setVisible(true);
//				lblS1.setVisible(true);
//				lblS.setVisible(true);
//				lblS3.setVisible(true);
//				label_0.setVisible(true);
//				label_1.setVisible(true);
//				label_2.setVisible(true);
//				label_3.setVisible(true);
//				label_4.setVisible(true);
//				label_5.setVisible(true);
//				lblAsin.setText(products[index].toString());
//				lblReview1.setText(temp[0]);
//				lblReview2.setText(temp[1]);
//				lblReview3.setText(temp[2]);
//				
//				
//			}
//		});
//		btnGo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		
//		GridBagConstraints gbc_btnGo = new GridBagConstraints();
//		gbc_btnGo.anchor = GridBagConstraints.SOUTH;
//		gbc_btnGo.insets = new Insets(0, 0, 5, 5);
//		gbc_btnGo.gridx = 2;
//		gbc_btnGo.gridy = 2;
//		frame.getContentPane().add(btnGo, gbc_btnGo);
						
						JLabel lblUsearch = new JLabel("Usearch");
						GridBagConstraints gbc_lblUsearch = new GridBagConstraints();
						gbc_lblUsearch.insets = new Insets(0, 0, 5, 5);
						gbc_lblUsearch.gridx = 1;
						gbc_lblUsearch.gridy = 1;
						frame.getContentPane().add(lblUsearch, gbc_lblUsearch);
		

		
		productTF = new JTextField();
		productTF.setText("Enter Product ID...");
		GridBagConstraints gbc_productTF = new GridBagConstraints();
		gbc_productTF.insets = new Insets(0, 0, 5, 5);
		gbc_productTF.gridx = 1;
		gbc_productTF.gridy = 3;
		frame.getContentPane().add(productTF, gbc_productTF);
		productTF.setColumns(10);
				
				
				//		GridBagConstraints gbc_btnGo = new GridBagConstraints();
				//		gbc_btnGo.insets = new Insets(0, 0, 5, 5);
				//		gbc_btnGo.gridx = 1;
				//		gbc_btnGo.gridy = 2;
				//		frame.getContentPane().add(btnGo, gbc_btnGo);
						
				
						
						JLabel lblProduct = new JLabel("Product");
						GridBagConstraints gbc_lblProduct = new GridBagConstraints();
						gbc_lblProduct.insets = new Insets(0, 0, 5, 5);
						gbc_lblProduct.gridx = 1;
						gbc_lblProduct.gridy = 5;
						frame.getContentPane().add(lblProduct, gbc_lblProduct);
						
						lblProduct.setVisible(false);
				
				JLabel lblError = new JLabel("Product ID.. is not valid");
				GridBagConstraints gbc_lblError = new GridBagConstraints();
				gbc_lblError.insets = new Insets(0, 0, 5, 5);
				gbc_lblError.gridx = 2;
				gbc_lblError.gridy = 5;
				frame.getContentPane().add(lblError, gbc_lblError);
				lblError.setVisible(false);
				
				JLabel lblAsin = new JLabel("ASIN:");
				GridBagConstraints gbc_lblAsin = new GridBagConstraints();
				gbc_lblAsin.insets = new Insets(0, 0, 5, 5);
				gbc_lblAsin.gridx = 2;
				gbc_lblAsin.gridy = 6;
				frame.getContentPane().add(lblAsin, gbc_lblAsin);
				lblAsin.setVisible(false);
		
				
				JLabel lblReview = new JLabel("Review");
				GridBagConstraints gbc_lblReview = new GridBagConstraints();
				gbc_lblReview.insets = new Insets(0, 0, 5, 5);
				gbc_lblReview.gridx = 1;
				gbc_lblReview.gridy = 7;
				frame.getContentPane().add(lblReview, gbc_lblReview);
				
				lblReview.setVisible(false);
		
		JLabel label_0 = new JLabel("1.");
		GridBagConstraints gbc_label_0 = new GridBagConstraints();
		gbc_label_0.insets = new Insets(0, 0, 5, 5);
		gbc_label_0.gridx = 1;
		gbc_label_0.gridy = 8;
		frame.getContentPane().add(label_0, gbc_label_0);
		label_0.setVisible(false);
		
		JLabel lblReview1 = new JLabel("one");
		GridBagConstraints gbc_lblReview1 = new GridBagConstraints();
		gbc_lblReview1.insets = new Insets(0, 0, 5, 5);
		gbc_lblReview1.gridx = 2;
		gbc_lblReview1.gridy = 8;
		frame.getContentPane().add(lblReview1, gbc_lblReview1);
		lblReview1.setVisible(false);
		
		JLabel label_1 = new JLabel("2.");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 9;
		frame.getContentPane().add(label_1, gbc_label_1);
		label_1.setVisible(false);
		
		JLabel lblReview2 = new JLabel("two");
		GridBagConstraints gbc_lblReview2 = new GridBagConstraints();
		gbc_lblReview2.insets = new Insets(0, 0, 5, 5);
		gbc_lblReview2.gridx = 2;
		gbc_lblReview2.gridy = 9;
		frame.getContentPane().add(lblReview2, gbc_lblReview2);
		lblReview2.setVisible(false);
		
		JLabel label_2 = new JLabel("3.");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 10;
		frame.getContentPane().add(label_2, gbc_label_2);
		label_2.setVisible(false);
		
		JLabel lblReview3 = new JLabel("three");
		GridBagConstraints gbc_lblReview3 = new GridBagConstraints();
		gbc_lblReview3.insets = new Insets(0, 0, 5, 5);
		gbc_lblReview3.gridx = 2;
		gbc_lblReview3.gridy = 10;
		frame.getContentPane().add(lblReview3, gbc_lblReview3);
		lblReview3.setVisible(false);
		
		JLabel lblSuggestions = new JLabel("Suggestions");
		GridBagConstraints gbc_lblSuggestions = new GridBagConstraints();
		gbc_lblSuggestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuggestions.gridx = 1;
		gbc_lblSuggestions.gridy = 12;
		frame.getContentPane().add(lblSuggestions, gbc_lblSuggestions);
		lblSuggestions.setVisible(false);
		
		JLabel label_3 = new JLabel("1.");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 13;
		frame.getContentPane().add(label_3, gbc_label_3);
		label_3.setVisible(false);
		
		JLabel lblS1 = new JLabel("S1");
		GridBagConstraints gbc_lblS1 = new GridBagConstraints();
		gbc_lblS1.insets = new Insets(0, 0, 5, 5);
		gbc_lblS1.gridx = 2;
		gbc_lblS1.gridy = 13;
		frame.getContentPane().add(lblS1, gbc_lblS1);
		lblS1.setVisible(false);
		
		JLabel label_4 = new JLabel("2.");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 14;
		frame.getContentPane().add(label_4, gbc_label_4);
		label_4.setVisible(false);
		
		JLabel lblS2 = new JLabel("S2");
		GridBagConstraints gbc_lblS2 = new GridBagConstraints();
		gbc_lblS2.insets = new Insets(0, 0, 5, 5);
		gbc_lblS2.gridx = 2;
		gbc_lblS2.gridy = 14;
		frame.getContentPane().add(lblS2, gbc_lblS2);
		lblS2.setVisible(false);
		

		
		JLabel label_5 = new JLabel("3.");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 15;
		frame.getContentPane().add(label_5, gbc_label_5);
		
		JLabel lblS3 = new JLabel("S3");
		GridBagConstraints gbc_lblS3 = new GridBagConstraints();
		gbc_lblS3.insets = new Insets(0, 0, 5, 5);
		gbc_lblS3.gridx = 2;
		gbc_lblS3.gridy = 15;
		frame.getContentPane().add(lblS3, gbc_lblS3);
		lblS3.setVisible(false);
		label_5.setVisible(false);
		
		JButton btnGo = new JButton("GO!");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				Sort.sortAsin(products, 542684);
				int index = Search.searchProductAsin(productTF.getText(), products);
				if(index < 0) {
					lblError.setVisible(true);
					lblProduct.setVisible(false);
					lblAsin.setVisible(false);
					lblReview.setVisible(false);
					lblReview1.setVisible(false);
					lblReview2.setVisible(false);
					lblReview3.setVisible(false);
					lblSuggestions.setVisible(false);
					lblS2.setVisible(false);
					lblS3.setVisible(false);
					lblS1.setVisible(false);
					label_0.setVisible(false);
					label_1.setVisible(false);
					label_2.setVisible(false);
					label_3.setVisible(false);
					label_4.setVisible(false);
					label_5.setVisible(false);
				} else {
					Graph digraph = new Graph(products, indexOfProduct(products, productTF.getText()));
					Product[] connected = digraph.connectedProducts(); 
					Sort.sortRating(connected, connected.length);
					String[] temp = printReviews(reviews, productTF.getText());
					String[] suggestions = printAlternatives(connected);
					
	//				lblAsintext.setText(Integer.toString(index));
					lblError.setVisible(false);
					lblProduct.setVisible(true);
					lblAsin.setVisible(true);
					
					
					lblReview.setVisible(true);
					lblReview1.setVisible(true);
					lblReview2.setVisible(true);
					lblReview3.setVisible(true);
					lblSuggestions.setVisible(true);
					lblS2.setVisible(true);
					lblS3.setVisible(true);
					lblS1.setVisible(true);
					label_0.setVisible(true);
					label_1.setVisible(true);
					label_2.setVisible(true);
					label_3.setVisible(true);
					label_4.setVisible(true);
					label_5.setVisible(true);
					lblAsin.setText(products[index].toString());
					lblReview1.setText(temp[0]);
					lblReview2.setText(temp[1]);
					lblReview3.setText(temp[2]);
					lblS1.setText(suggestions[0]);
					lblS2.setText(suggestions[1]);
					lblS3.setText(suggestions[2]);
				}
				
				
				
			}
		});
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.anchor = GridBagConstraints.SOUTH;
		gbc_btnGo.insets = new Insets(0, 0, 5, 5);
		gbc_btnGo.gridx = 2;
		gbc_btnGo.gridy = 3;
		frame.getContentPane().add(btnGo, gbc_btnGo);
		
		
	}

}
