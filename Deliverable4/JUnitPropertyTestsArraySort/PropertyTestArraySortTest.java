import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class PropertyTestArraySortTest {
	@Test
	public void test() {
		Random r = new Random();
		int arraySize = 0;
		for(int i=0;i<100;i++){ //100 arrays
			arraySize = r.nextInt(100)+1; //generates size of array
			int arr[] = new int[arraySize]; //generates array
			for(int x=0; x<arraySize;x++){ //fills array
				arr[x] = r.nextInt(100); //with random numbers
			}
			//TESTS FOR EACH ARRAY
			
			//TEST 1: Sorting Multiple Times Returns Same Result
			int arrDupe[] = new int[arraySize];
			int arrDupeSize[] = new int[arraySize];
			for(int y=0;y<arraySize;y++){ //deep copy the array
				arrDupe[y]=arr[y];
				arrDupeSize[y]=arr[y];
			}
			Arrays.sort(arr);
			Arrays.sort(arrDupe);
			assertArrayEquals(arr,arrDupe);
			
			//TEST 2: Last Number Larger Than First
			//test that the last number is larger than the first
			int difference = arr[0]-arr[arraySize-1];
			boolean x = true; //assume true
			if (difference > 0) x=false; //if difference is positive the first is larger than the last
			assertTrue(x);
			
			//TEST 3: Size Before Sorting is Same Size as After
			int sizeBefore = arrDupeSize.length;
			Arrays.sort(arrDupeSize);
			int sizeAfter = arrDupeSize.length;
			assertEquals(sizeBefore,sizeAfter);
		}
	}
}
