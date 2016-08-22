package shapeGroupPeriodics;

import java.util.ArrayList;

public class KeyValueMap<K, V> {
	
	private ArrayList<KeyValue<K, V>> list;
	
	public KeyValueMap() {
		list = new ArrayList<KeyValue<K, V>>();
	}
	
	public void put(K key, V value) {
		list.add((KeyValue<K, V>) (new KeyValue<K, V>(key, value)));
	}
	
	public V get(K key) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getKey() == key)
				return list.get(i).getValue();
		}
		return null;
	}
	
	public int size() {
		return list.size();
	}
}
