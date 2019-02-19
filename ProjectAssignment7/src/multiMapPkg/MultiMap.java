/**
 * The MultiMap interface
 * 
 * It is a generic interface with type parameters:
 *    K -- type of the key
 *    V -- type of the value associated with the key
 */
package multiMapPkg;

import java.util.Collection;
import java.util.Set;

public interface MultiMap<K,V> {
	
	/**
	 * Check whether the map contains the value specified.
	 * @param value -- the value to search for
	 * @return true if the map contains the value, false otherwise
	 */
	public boolean contains(V value);
	
	/**
	 * Get the collection of values associated with the specified key
	 * @param key -- the key to retrieve
	 * @return the Collection of values
	 */
	public Collection<V> get(K key);
	
	/**
	 * Check if the map is empty
	 * @return true if it is empty, false if not empty
	 */
	public boolean isEmpty();
	
	/**
	 * Get the set of keys in the map
	 * @return set of keys in the map
	 */
	public Set<K> keySet();
	
	/**
	 * Add the value to the map associated with the specified key
	 * @param key -- the key to store against
	 * @param value -- the value to add to the map at the key
	 */
	public void put(K key, V value);
	
	/**
	 * Remove all values associated with the specified key
	 * @param key -- the key to remove values from
	 * @return the Collection of values removed
	 */
	public Collection<V> remove(K key);
	
	/**
	 * Removes a specific value from map. 
	 * @param key -- the key to remove value from
	 * @param value -- the value to remove
	 * @return the value removed, null if nothing removed
	 */
	public V remove(K key, V value);
	
	/**
	 * Number of objects in the map
	 * @return Number of objects in the map
	 */
	public int size();
	
	/**
	 * Get a collection containing all the values in the map
	 * @return a collection view of the values contained in this map
	 */
	public Collection<V> values();

}