package es.baki.dsp5;

public class Node {
	private int value, hashCode;
	private String key;

	public Node(String key) {
		this.key = key;
		this.value = 1;

		this.hashCode = HashTable.stringToHash(key);
	}

	public int getHashCode() {
		return this.hashCode;
	}

	public int getValue() {
		return value;
	}

	public void increment() {
		value++;
	}

	public String getKey() {
		return key;
	}
}
