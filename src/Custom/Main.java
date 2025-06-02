package Custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Main {
	
	public static void main(String[] args) {
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
	}
}
