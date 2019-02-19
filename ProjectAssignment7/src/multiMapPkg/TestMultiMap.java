package multiMapPkg;

/**
 * A test program to test the MultiMap implementation.
 */

import java.util.Collection;
//import java.util.Map;
//import java.util.Set;
import java.util.Iterator;

public class TestMultiMap {

	MultiMap<Integer, String> map;
	
	public static void main(String[] args) {
		new TestMultiMap();
	}
	
	/**
	 * Do all the testing.
	 */
	public TestMultiMap() {
		map = new ListMultiMap<Integer, String>();
		
		// test put() method
		map.put(5, "apple");
		map.put(4, "orange");
		map.put(5, "blueberry");
		map.put(5, "lemmon");
		map.put(4, "grapefruit");
		map.put(3, "banana");
		
		displayValues();
		
		// test contains() method
		String f = "orange";
		boolean b = map.contains(f);
		System.out.printf("\nThe map contains \"%s\": %s.\n\n", f, b);
		
		// test remove() method that removes a particular key-value entry
		displayValuesOfaGivenKey(5);
		map.remove(5, "apple");
		System.out.println("\nAfter \"apple\" is removed:");
		displayValuesOfaGivenKey(5);
		
		// test remove() method that removes all entries with a particular key
		Collection<String> c = map.remove(4);
		System.out.println("\nValues removed (with key = 4):");
		displayStringCollection(c);
		
		System.out.println("\nAfter values with key = 4 are removed:");
		displayValues();
		
		b = map.contains(f);
		System.out.printf("\nThe map contains \"%s\": %s.\n", f, b);
	}

	/**
	 * Display values in the map associated with a given key.
	 * @param key -- The key with which the values are associated.
	 */
	private void displayValuesOfaGivenKey(int key) {
		System.out.printf("Values with key=%d:\n", key);
		Collection<String> obj = map.get(key);
		displayStringCollection(obj);
	}

	/**
	 * Display the map with the Collection view values().
	 */
	private void displayValues() {
		Collection<String> values = map.values();
		System.out.println("All values:");
		displayStringCollection(values);
	}

	/**
	 * Display the values in a collection.
	 * @param c -- Collection of Strings.
	 */
	private void displayStringCollection(Collection<String> c) {
		Iterator<String> it = c.iterator();
		System.out.print("[");
		while (it.hasNext()) {
			System.out.printf("%s", it.next());
			if (it.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}
}
