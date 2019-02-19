/*
 ============================================================================
 Name        : Program Assignment 7, ListMultiMap.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/20/2018
 Description : This class implements the MultiMap interface that the professor
 			   provided us. Creates a HashMap with a key of type <K> and a 
 			   Collection<V> of values. Multiple methods are implemented to 
 			   manipulate and interact with the map.
 ============================================================================
 */
package multiMapPkg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class ListMultiMap<K,V> implements MultiMap<K,V> {
	
	//ListMultiMap Constructor that creates a hashmap.
	private Map<K, Collection<V>> map = new HashMap<>();
	
	/**
	 * Check whether the map contains the value specified.
	 * @param value -- the value to search for
	 * @return true if the map contains the value, false otherwise
	 */
	@Override
	public boolean contains(V value) {
		//Checks each collection to see if it contains the value
		for(Collection<V> collection: map.values()){
			//Contains value
			if(collection.contains(value)) {
				return true;
			}
		}
		//Doesnt contain value
		return false;
	}//End Contains 

	/**
	 * Get the collection of values associated with the specified key
	 * @param key -- the key to retrieve
	 * @return the Collection of values
	 */
	@Override
	public Collection<V> get(K key) {
		return map.get(key);
	}//End get

	/**
	 * Check if the map is empty
	 * @return true if it is empty, false if not empty
	 */
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}//end isEmpty

	/**
	 * Get the set of keys in the map
	 * @return set of keys in the map
	 */
	@Override
	public Set<K> keySet() {
		return map.keySet();
	}//end keySet

	/**
	 * Add the value to the map associated with the specified key
	 * @param key -- the key to store against
	 * @param value -- the value to add to the map at the key
	 */
	@Override
	public void put(K key, V value) {
		//Checks to see if the key is in the map. If key isnt in the map, add the key and arraylist as its value
		if(map.get(key) == null) {
			map.put(key, new ArrayList<V>());
		}
		//add value to that Key's collection
		map.get(key).add(value);
	}//end put

	/**
	 * Remove all values associated with the specified key
	 * @param key -- the key to remove values from
	 * @return the Collection of values removed
	 */
	@Override
	public Collection<V> remove(K key) {
		return map.remove(key);
	}//end remove
	
	/**
	 * Removes a specific value from map. 
	 * @param key -- the key to remove value from
	 * @param value -- the value to remove
	 * @return the value removed, null if nothing removed
	 */
	@Override
	public V remove(K key, V value) {
		V val = null;
		//Checks to see if the key exists
		if(map.get(key) != null) {
			//Gets the collection for the given key
			Collection<V> collection = map.get(key);
			//Checks to see is the keys collection contains the value. Removes it and returns the value if true.
			if(collection.contains(value)) {
				val = value;
				collection.remove(value);
			}
		}
		return val;
	}//end remove
	
	/**
	 * Number of objects in the map
	 * @return Number of objects in the map
	 */
	@Override
	public int size() {
		return map.size();
	}//End Size
	
	/**
	 * Get a collection containing all the values in the map
	 * @return a collection view of the values contained in this map
	 */
	@Override
	public Collection<V> values() {
		//Makes a collection for all values to be added too.
		ArrayList<V> collection = new ArrayList<V>();
		//Goes through each collection in the map
		for(Collection<V> values: map.values()){
			//iterates each value in the collection and adds it to the overall collection for all values
			for(V val: values) {
				collection.add(val);//add to overall collection
			}
		}
		return collection;
	}//End Values

}
