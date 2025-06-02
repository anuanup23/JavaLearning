package Custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {
	
	public static void main(String[] args) {
		
		
		// custom hashmap Testing 
		Random r = new Random();
		List<Integer> keyList = new ArrayList<>(100);
		MyHashMap<Integer,String> myHashMap = new MyHashMap<>();
		for(int i = 0; i < 1000; ++i) {
			int key = r.nextInt(1000);
			keyList.add(key);
			myHashMap.put(key, UUID.randomUUID().toString());
		}	
		for(int i = 0; i < keyList.size(); ++i) {
			System.out.println(myHashMap.getKey(keyList.get(i)));
		}
		
		
		
		
		
		// Iterator testing 
		MyIterableList<Integer> myList = new MyIterableList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		
		Iterator<Integer> iterator = myList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
