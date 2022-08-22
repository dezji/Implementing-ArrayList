package com.dezji;

import static java.lang.System.out;

public class TestRun {

	public static void main(String[] args) throws Exception {

		MyArrayList<String> names = new MyArrayList<>();

		names.add("Rue");
		names.add("Nate");
		names.add("Cassie");
		names.add("Maddy");
		names.add("Cal");
		names.add("Jules");
		names.add("Gia");
		names.add("Fezco");
		
		for (String name : names) {
			out.print(name + "\n" );
		}

	}

}
