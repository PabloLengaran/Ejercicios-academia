package ShoppingCart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShoppingCart {
	
	private ArrayList <Product> items;
	private HashSet<Product> hashItems;
	
	public ShoppingCart() {
		items = new ArrayList<Product> ();
		hashItems = new HashSet<Product>();
	}
	
	public double getBalance() {
		double balance = 0.00;
		for (Iterator<Product> i = items.iterator(); i.hasNext();){
			Product item = (Product)i.next();
			balance += item.getPrice();
		}
		return balance;
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public void addHashItem (Product item) {
		hashItems.add(item);
	}
	
	public void removeItem(Product item)
			throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();}
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public void empty() {
		items.clear();
	}
	
	public void saveDataInTextFile() {
		File file = new File("data.txt");
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Product product : items) {
				bw.write(product.toString() + "\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void readDataFromTextFile () {
		try {
			FileReader fr = new FileReader("data.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea = null;
			items.clear();
			
				while ((linea = br.readLine()) != null) {
					Product pr = lineToProduct(linea);
					items.add(pr);
					
				}
			if (br.readLine() == null) {
				br.close();
				fr.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private Product lineToProduct(String linea) {
		String [] atributos = linea.split(",");
		String [] titles = atributos[0].split(":");
		String [] prices = atributos [1].split(":");
		double precio = Double.parseDouble(prices[1]);
		Product pr = new Product(titles[0], precio);
		return pr;
	}
	
	
	
	public static void main(String[] args) {
		ShoppingCart sc = new ShoppingCart();
		sc.hashItems.add(new Product("Manzana", 5));
		sc.hashItems.add(new Product("Pera", 10));
		sc.hashItems.add(new Product("Naranja", 7));
		
		for (Product product : sc.hashItems) {
			System.out.println(product);
		}

		
	}
}

