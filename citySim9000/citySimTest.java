package citySim9000;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
public class citySimTest {
	
	//test handle args with no args provided
	@Test
	public void testArgsNone(){
		String [] args = {};
		int seed = handleArgs(args);
		assertEquals(seed,-1);
	}
	
	//test handle args with more than one args provided
	@Test
	public void testArgsMany(){
		String [] args = {10,25};
		int seed = handleArgs(args);
		assertEquals(seed,-1);
	}
	
	//test handle args with non integer arg provided
		@Test
		public void testArgsNonInt(){
			String [] args = {"asdf"};
			int seed = handleArgs(args);
			assertEquals(seed,-2);
		}
	
	//tests if driver starts outside via fifth that first move is to the mall
	@Test
	public void testNextMoveValOutsideFourth(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(2);
		
		int nextMove = nextMove(0,mockDriver,0); //rand doesnt matter here
		assertEquals(nextMove,0);
	}

	//tests if driver starts outside via fifth that first move is to the university
	@Test
	public void testNextMoveValOutsideFifth(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(3);
		
		int nextMove = nextMove(0,mockDriver,0); //rand doesnt matter here
		assertEquals(nextMove,5);
	}
	
	//tests to go from mall to bookstore
	@Test
	public void testNextMoveValMallBook(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(0);
		
		int nextMove = nextMove(0,mockDriver,1); //turn doesnt matter
		assertEquals(nextMove,1);
	}
	
	//from mall to coffee shop, which also covers bookstore to university
	@Test
	public void testNextMoveValMallCoffee(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(1);
		
		int nextMove = nextMove(1,mockDriver,1); //turn doesnt matter
		assertEquals(nextMove,5);
	}
	
	//tests that university to coffee shop works
	@Test
	public void testNextMoveValUniCoffee(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(5);
		
		int nextMove = nextMove(0,mockDriver,1); //turn doesnt matter
		assertEquals(nextMove,4);
	}
	
	//from university to bookstore, which also covers bookstore to university
	@Test
	public void testNextMoveValUniBook(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(5);
		
		int nextMove = nextMove(1,mockDriver,1); //turn doesnt matter
		assertEquals(nextMove,1);
	}
	
	//test exit 1 which is from bookstore to outside city via fourth
	public void testNextMoveValBookOut(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(1);
		
		int nextMove = nextMove(0,mockDriver,1); //turn doesnt matter
		assertEquals(nextMove,2);
	}
	
	//test exit 2 which is from coffee shop to outside city via fifth
	public void testNextMoveValBookOut(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(4);
		
		int nextMove = nextMove(0,mockDriver,1); //turn doesnt matter
		assertEquals(nextMove,3);
	}
	
	//test Via when moving along fourth avenue
	public testFourthAvenue(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(0);
		when(mockDriver.getNext()).thenReturn(1);
		String via = via(mockDriver);
		assertEquals(via,"Fourth Avenue");
	}
	
	//test Via when moving along fifth avenue
	public testFourthAvenue(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(5);
		when(mockDriver.getNext()).thenReturn(4);
		String via = via(mockDriver);
		assertEquals(via,"Fifth Avenue");
	}
	
	//test Via when moving along chirp street
	public testFourthAvenue(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(1);
		when(mockDriver.getNext()).thenReturn(5);
		String via = via(mockDriver);
		assertEquals(via,"Chirp Street");
	}
	
	//test Via when moving along meow street
	public testFourthAvenue(){
		Driver mockDriver = mock(Driver.class);
		when(mockDriver.getCurrent()).thenReturn(0);
		when(mockDriver.getNext()).thenReturn(4);
		String via = via(mockDriver);
		assertEquals(via,"Meow Street");
	}
}
