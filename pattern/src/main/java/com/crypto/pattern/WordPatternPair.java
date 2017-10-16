package com.crypto.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Container for a dictionary Word and the corresponding pattern
public class WordPatternPair {

	static Map<Character, Character> dictionary = new HashMap<>();
	private static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	private String word;
	private List<Character> pattern = new ArrayList<>();

	public WordPatternPair(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public List<Character> getPattern() {
		if (pattern.isEmpty()) {
			dictionary.clear();
			// word = new StringBuilder(word).reverse().toString();// Reverse : HELLO -> OLLEH
			int alphCtr = 0;
			List<Character> patt = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				Character wordChar = word.charAt(i);
				Character patternChar;
				if (dictionary.containsKey(wordChar)) {
					patternChar = dictionary.get(wordChar);
				} else {
					patternChar = ALPHABET[alphCtr];
					dictionary.put(wordChar, patternChar);
					alphCtr++;
				}
				patt.add(patternChar);
			}
			pattern = patt;
		}
		return pattern;
	}

	@Override
	public String toString() {
		return "WordPatternPair [word=" + word + ", pattern=" + pattern + "]";
	}

}
