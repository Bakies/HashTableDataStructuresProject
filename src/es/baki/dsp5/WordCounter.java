package es.baki.dsp5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
	public static void main(String... strings) {
		Scanner scan = new Scanner(System.in), fileScanner;
		System.out.print("Enter the size of the hashtable: ");
		HashTable ht = new HashTable(scan.nextInt());
		System.out.print("Enter the filename: ");
		scan.nextLine();
		String filename = scan.nextLine();
		File file = new File(filename);
		scan.close();

		try {
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		while (fileScanner.hasNext()) {
			String line = fileScanner.nextLine();
			for (String word : line.split(" "))
				ht.addToTable(word);
		}

		System.out.println(ht);
		System.out.println(ht.debug());
		fileScanner.close();
	}
}
