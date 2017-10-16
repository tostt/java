package com.crypto.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	private static final List<Character> targetPattern = Arrays.asList('A', 'B', 'C', 'D', 'E', 'B', 'F', 'A', 'G');

	private static final Path PATH = Paths.get("data", "dict-fr");
	// private static final Path PATH = Paths.get("data", "words");

	public static void main(String[] args) {
		System.out.println("Patterns");
		System.out.println("Dictionary : " + PATH.toAbsolutePath().toString());

		List<WordPatternPair> pairs = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(PATH)) {
			pairs = br.lines()
					.map(String::toUpperCase)
					.map(str->str.replaceAll("[^A-Za-z]+", ""))
					.distinct()
					.map(WordPatternPair::new)					
					.filter(p -> p.getPattern().equals(targetPattern))
					// .filter(p->p.getWord().length()==15)
					// .filter(p->p.getWord().charAt(6)=='E')
					// .filter(p->p.getWord().charAt(8)=='E')
					// .filter(p->p.getWord().charAt(14)=='E')
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Target pattern: " + targetPattern);
		pairs.forEach(p -> System.out.println(p.getWord()));
		System.out.println(pairs.size() + " elements found");

	}
	
}
