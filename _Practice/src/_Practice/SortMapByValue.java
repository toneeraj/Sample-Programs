package _Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByValue {
	public static void main(String[] args) {

		Map<String, Integer> m1 = new HashMap<>();
		m1.put("L", 2000);
		m1.put("A", 10);
		
		printMap(m1);

		Set<Entry<String, Integer>> set = m1.entrySet();

		List<Entry<String, Integer>> list = new ArrayList<>(set);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}

		});

		//printMap(m1);
	}

	private static void printMap(Map m) {

		Set<Entry<String, Integer>> s = m.entrySet();

		Iterator<Entry<String, Integer>> iterator = s.iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}
