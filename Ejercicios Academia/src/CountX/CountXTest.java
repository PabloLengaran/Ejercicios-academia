package CountX;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountXTest {

	@Test
	public void test() {
		CountX c = new CountX();
		assertEquals(2, c.countX("xbx"));
	}

}
