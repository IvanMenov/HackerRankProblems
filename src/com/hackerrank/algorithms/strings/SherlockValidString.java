package com.hackerrank.algorithms.strings;

import java.lang.reflect.Field;
import java.util.Scanner;


//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class SherlockValidString {
    private static final Scanner scanner = new Scanner(System.in); 

	public static void main(String[] args) {
		String s = scanner.nextLine();
		String result = isValid(s);
		System.out.println(result);
		scanner.close();
	}
    
 // Complete the isValid function below.
    static String isValid(String s) {     	
    	char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    	int[] characterFrequency = new int[alphabet.length];
		countCharacterFrequencies(s, characterFrequency);

		//index represents character frequency and value represents frequency for character frequency 
		int[] frequenciesCount = new int[characterFrequency.length];
		int smallestFrequency =Integer.MAX_VALUE;
		int biggestFrequency = 0;
		
		for (int i = 0; i < characterFrequency.length; i++) {
			if(characterFrequency[i] > biggestFrequency) {
				biggestFrequency = characterFrequency[i];
			}
			if(characterFrequency[i] < smallestFrequency && characterFrequency[i] != 0) {
				smallestFrequency = characterFrequency[i];
			}
			if(characterFrequency[i] != 0) {
				frequenciesCount[characterFrequency[i]]++;
			}
			
		}
		if(smallestFrequency == biggestFrequency) {
			return "YES";
		}
		int valueToRemoveFromCharacterFrequencyArray = 0;
		int tempSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < frequenciesCount.length; i++) {
			if(frequenciesCount[i] < tempSmallest && frequenciesCount[i] != 0) {
				tempSmallest = frequenciesCount[i];
				valueToRemoveFromCharacterFrequencyArray = i;
			}
		}
		smallestFrequency =Integer.MAX_VALUE;
		biggestFrequency = 0;
		
		for (int i = 0; i < characterFrequency.length; i++) {
			if(characterFrequency[i] == valueToRemoveFromCharacterFrequencyArray) {
				characterFrequency[i]--;
				break;
			}
		}
		for (int i = 0; i < characterFrequency.length; i++) {
			if(characterFrequency[i] > biggestFrequency) {
				biggestFrequency = characterFrequency[i];
			}
			if(characterFrequency[i] < smallestFrequency && characterFrequency[i] != 0) {
				smallestFrequency = characterFrequency[i];
			}
		}
		if(smallestFrequency == biggestFrequency) {
			return "YES";
		}
		return "NO";
    }

	private static void countCharacterFrequencies(String s, int[] characterFrequency) {
		try {
			// using reflection to get the inner char array of the string(performs faster
			// for large strings)
			final Field field = String.class.getDeclaredField("value");
			field.setAccessible(true);
			final char[] chars = (char[]) field.get(s);
			final int len = chars.length;
			for (int i = 0; i < len; i++) {
				if (chars[i] <= ' ') {
					throw new RuntimeException("Bzzzt -- Illegal Character!!");
				}
				characterFrequency[chars[i] - 'a']++;
			}

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
 
}
