import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArrListDemo {

	@Test
	public void listDemo () {
		
		List<String> list = new ArrayList<> (10);
		
		//Add 10 elements
		for (int i = 0; i< 10; i++) {
			list.add("Element : "+i);
		}
		
		
		
		list.remove(9);
		
		
		assertEquals(100, list.size());
	}

}
