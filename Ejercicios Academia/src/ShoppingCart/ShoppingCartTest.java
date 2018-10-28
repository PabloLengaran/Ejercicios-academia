/**
 * 
 */
package ShoppingCart;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author igoraresti
 *
 */
public class ShoppingCartTest {

	@Test
	public void whenCreatedCartHas0Items() {
		ShoppingCart sc = new ShoppingCart();
		assertEquals(0, sc.getItemCount(), 0);
	}
	
	@Test
	public void whenEmptyCartHas0Items() {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("Apple", 5);
		sc.addItem(p);
		sc.empty();
		assertEquals(0, sc.getItemCount(), 0);
	}
	
	@Test
	public void whenItemAddCartHasMoreItems() {
		ShoppingCart sc = new ShoppingCart();
		int items = sc.getItemCount();
		Product p = new Product("Apple", 5);
		sc.addItem(p);
		assertTrue(items < sc.getItemCount());
	}
	
	@Test
	public void whenItemAddCartBalanceIncrements() {
		ShoppingCart sc = new ShoppingCart();
		double balance = sc.getBalance();
		Product p = new Product("Apple", 5);
		sc.addItem(p);
		assertEquals(5, sc.getBalance() + balance, 0);
	}
	
	@Test
	public void whenItemRemovedCartHasLessItems() {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("Apple", 5);
		sc.addItem(p);
		int items = sc.getItemCount();
		try {
			sc.removeItem(p);
			assertTrue(items > sc.getItemCount());
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Test de excepciones
	
	// Forma 1: Capturando la excepción y usando Fail
	
	@Test
	public void whenItemRemovedNotInCartThrowsException1() {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("Apple", 5);
		try {
			sc.removeItem(p);
			fail();
		} catch (ProductNotFoundException e) {
		}
	}
	
	// Forma 2: Creando una regla que se espera esa excepción. Se puede reutilizare n varios test.
	// En el test hay que añadir que se espera esa clase con el objeto thrown
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void whenItemRemovedNotInCartThrowsException2() throws ProductNotFoundException {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("Apple", 5);
		thrown.expect(ProductNotFoundException.class);
		sc.removeItem(p);
	}
	
	// Forma 3: Añadiendo al tag Test que se espera esa excepción (La forma que más me gusta)
	
	@Test(expected = ProductNotFoundException.class)
	public void whenItemRemovedNotInCartThrowsException3() throws ProductNotFoundException {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("Apple", 5);
		sc.removeItem(p);
	}

	public void whenSaveDataInTextFileTest() {
		File file = new File("data.txt");
		if (file.exists()) {
			file.delete();
		}
		
		assertFalse(file.exists());
		ShoppingCart sc = new ShoppingCart();
		sc.addItem(new Product("Naranja", 5));
		sc.addItem(new Product("Manzana", 7));
		sc.saveDataInTextFile();
		assertTrue(file.exists());
		assertTrue(file.getTotalSpace() > 0);
	}
	
	public void whenReadDataFromTextFileTest() {
		File file = new File("data.txt");
		if (file.exists()) {
			file.delete();
		}
		
		assertFalse(file.exists());
		ShoppingCart shc = new ShoppingCart();
		shc.addItem(new Product("Naranja", 5));
		shc.addItem(new Product("Manzana", 7));
		shc.saveDataInTextFile();
		assertTrue(file.exists());
		assertTrue(file.getTotalSpace() > 0);
		
		ShoppingCart sc = new ShoppingCart();
		sc.readDataFromTextFile();
		assertEquals(shc.getItemCount(), sc.getItemCount());
		
	}
}
