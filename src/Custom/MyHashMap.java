package Custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K,V> {
	
	List<MapNode<K,V>> bucket;
	int capacity;
	int size;
	int INITIAL_CAPACITY = 5;
	private final double LOAD_FACTOR = 0.75;
	
	public MyHashMap() {
		this.bucket = new ArrayList<>();
		this.capacity =  INITIAL_CAPACITY;
		for(int i = 0; i < this.INITIAL_CAPACITY; ++i) {
			this.bucket.add(null);
		}
		
	}
	
	public V getKey(K key) {
		int index = getHashFunction(key) % this.capacity;
		MapNode<K,V> head = bucket.get(index);
		while(head != null) {
			if(Objects.equals(key, head.key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;	
	}
	
	private int getHashFunction(K key) {
		if(Objects.isNull(key)) return 0;
		return key.hashCode();
	}
	
	public void put(K key, V value) {
		int index = getHashFunction(key) % this.capacity;
		MapNode<K,V> new_node = new MapNode<K, V>(key, value);
		MapNode<K,V> head = bucket.get(index);
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		this.size++;
		head = bucket.get(index);
		new_node.next = head;
		bucket.set(index, new_node);
		
		if((double)size/capacity >= this.LOAD_FACTOR) {
			System.out.println("Rehashing");
			rehash();
		}
		
	}
	
	private void rehash() {
		this.capacity *= 2;
		List<MapNode<K,V>> temp = bucket; 
		bucket = new ArrayList<>();
		for(int i = 0; i < this.capacity; ++i) {
			bucket.add(null);	
		}
		size = 0;
		
		for(int i = 0; i < temp.size(); ++i) {
			MapNode<K,V> head = temp.get(i);
			while(head != null) {
				put(head.key, head.value);
				head = head.next;
			}
		}
		
	}
	
	public void remove(K key) {
		int index = getHashFunction(key) % this.capacity;
		MapNode<K,V> head = bucket.get(index);
		MapNode<K,V> prev = null;
		while(head != null) {
			if(Objects.equals(key, head.key)) {
				if(prev == null) {
					MapNode<K,V> nextNode = head.next;
					head.next = null;
					bucket.set(index, nextNode);
				}
				else {
					prev.next = head.next;
					head.next = null;
				}
				size--;
				break;
			}
			prev = head;
			head = head.next;
			
		}
	}
	private class MapNode<K, V>{
		 K key;
		 V value;
		 MapNode<K,V> next;
		 public MapNode(K key, V value) {
			 this.key = key;
			 this.value = value;
		 }
	}
}
