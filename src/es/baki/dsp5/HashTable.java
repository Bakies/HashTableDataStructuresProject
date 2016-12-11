package es.baki.dsp5;

import java.util.ArrayList;

public class HashTable {
	private ArrayList<Node>[] bucket;
	private int size;

	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		System.out.printf("Using size %d%n", size);
		this.size = size;
		bucket = new ArrayList[size];
		for (int x = 0; x < size; x++)
			bucket[x] = new ArrayList<Node>();
	}

	public Node contains(String s) {
		if (s == null)
			return null;
		for (Node n : bucket[stringToHash(s) % size]) {
			if (n == null)
				continue;
			if (n.getKey().equals(s))
				return n;

		}
		return null;
	}

	public void addToTable(String s) {
		Node n = contains(s);
		if (n != null) {
			n.increment();
			return;
		}
		n = new Node(s);
		int hash = stringToHash(s);
		bucket[hash % size].add(n);
	}

	@Override
	public String toString() {
		String ret = String.format("%-15s %5s%n", "Word", "Count");
		for (int i = 0; i < bucket.length; i++) {
			ArrayList<Node> al = bucket[i];
			for (Node n : al)
				ret += String.format("%-15s %5d%n", n.getKey(), n.getValue());
		}

		return ret;
	}

	public String debug() {
		String sizes = "List Sizes: ";
		for (int i = 0; i < bucket.length; i++) {
			sizes += bucket[i].size();
			if (i != bucket.length - 1)
				sizes += " ";
		}
		String ret = sizes + String.format("%n%-15s %7s %7s %5s%n", "Word", "Hash", "ModHash", "Count");
		for (int i = 0; i < bucket.length; i++) {
			ArrayList<Node> al = bucket[i];
			for (Node n : al)
				ret += String.format("%-15s %7d %7d %5d%n", n.getKey(), n.getHashCode(), n.getHashCode() % size,
						n.getValue());
		}

		return ret;
	}

	public static int stringToHash(String s) {
		int hash = 0;
		for (char c : s.toCharArray())
			hash += c;
		return hash;
	}

}
