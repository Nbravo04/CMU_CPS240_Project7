/*
 ============================================================================
 Name        : Program Assignment 7, Anagram.java
 Author      : Nicholas Bravata
 Class		 : CPS240
 CRN		 : 22359097
 Date		 : 11/20/2018
 Description : This program is the main for our project. It reads the file, 
 			   "word.txt" and searches for anagrams within the file. We do this
 			   by using our ListMultiMap and sorting the string alphabetically.
 			   We use sorted strings as Keys in our map and then add the unsorted
 			   string into its sorted string Key's value, which is a collection of 
 			   anagrams of that string. We then go through the map after we read the 
 			   entire file and remove collections of anagrams that are less than 3.
 			   Finally, we print of all remaining collections of anagrams.
 ============================================================================
 */
package multiMapPkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Anagram {
	
	//Declare map
	static MultiMap<String, String> map;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		
		//Initializers 
		String str, strSorted;
		//Set<String> keySet;
		int length;
		int n=0;
		map = new ListMultiMap<String, String>();//Init new map
		File file = new File("word.txt");//Init of File file
		Scanner sc = new Scanner(file);//Init of Scanner sc
		
		//Reads through every line of the file until there is nothing left
		while(sc.hasNext()) {
			str = sc.next();
			length = str.length();
			if(length >= 3) { //Words less than 3 characters cannot have 3 anagrams
				strSorted = stringSort(str);//Sort the string alphabetically
				map.put(strSorted, str);//Store the string in an anagram collection given its sorted str
			}
		}//End While
		
		sc.close();//Closes Scanner sc
		
		//Creates an iterator to go through all the keys in the map
		Iterator<String> iterator = map.keySet().iterator();
	    
		//Calls the check map method to check for anagrams more than 3
	    checkMap(iterator);
	    
		//Print all the collections of anagrams.
	    for(String key: map.keySet()) {
	    	System.out.println(map.get(key));
	    }
		
		
		
	}//End Main
	
	/**
	 * Sorts a string alphabetically
	 * @param s -- String to sort
	 * @return retVal -- The sorted string s
	 */
	private static String stringSort(String s) {
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}//End stringSort
	
	/**
	 * Goes through the map and checks each key's value to see if the values length is equal to our greater than 3.
	 * If the values length is less than 3 its key and values are removed from the map.
	 * @param keys -- An Iterator<String> of keys in the map.
	 */
	private static void checkMap(Iterator<String> keys) {
		while(keys.hasNext()){
		      String certification = keys.next();
		      if(map.get(certification).size() < 3){
		        keys.remove();
		      }
		}//End while
	}//End checkMap
	
}//End of Anagram Class
