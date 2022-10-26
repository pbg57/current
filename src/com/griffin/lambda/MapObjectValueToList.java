package com.griffin.lambda;

import java.util.Arrays;
import java.util.List;

public class MapObjectValueToList {
    /*
    Use a List stream to map an object's value to a new List
     */

	public static void main(String... args) {
		Document document1 = new Document(1, "The Sound of Music");
		Document document2 = new Document(2, "The World According to Garp");

		List<Document> documents = Arrays.asList(document1, document2);

		// map() uses a functional interface accepting Document and producing String.
		List<String> titles = documents.stream().map(Document::getTitle).toList();


		titles.forEach(System.out::println);

	}

	public static class Document {
		Integer ID;

		String title;

		public Document(Integer ID, String title) {
			this.ID = ID;
			this.title = title;
		}

		public Integer getID() {
			return ID;
		}

		public String getTitle() {
			return title;
		}
	}
}
