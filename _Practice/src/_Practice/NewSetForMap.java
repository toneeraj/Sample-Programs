package _Practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * although there is no Set backed by a ConcurrentHashMap. 
 * There is, however, a static method on the Collections class, newSetFromMap, 
 * which takes a Map and returns a Set, respecting the properties of the given map.
 */
public class NewSetForMap {

	public static void main(String[] args) {
		
		Map<String, Boolean> map = new ConcurrentHashMap<>();

		//Getting a concurrentHashSet pre Java 8
		Set<String> set = Collections.newSetFromMap(map);
		
		for (String str : set) {
			System.out.println(str);
		}
		
		set.add("Three");
		
		Set<Map.Entry<String, Boolean>> entry = map.entrySet();
		
		for(Map.Entry<String, Boolean> ent : entry) {
			System.out.println("key="+ent.getKey() +"  and value = " + ent.getValue());	
			//Prints - key=Three  and value = true
		}
	}
}
