package com.hackerrank.algorithms.strings;

import java.io.BufferedInputStream;
import java.io.IOException;


//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
	
public class SherlockValidString {
    private static final BufferedInputStream stream = new BufferedInputStream(System.in);
    
	public static void main(String[] args) throws IOException {
		int[] characterFrequency = new int[26];
		int ch;
		char c;
		while ((ch = stream.read()) != -1) {
			c = (char) ch;
			countCharacterFrequencies(c, characterFrequency);
		}

		stream.close();

		String result = isValid(characterFrequency);
	//	System.out.println(result);
		
	}
    
 // Complete the isValid function below.
    static String isValid(int[] characterFrequency) {
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

	private static void countCharacterFrequencies(char c, int[] characterFrequency) {
		characterFrequency[c - 'a']++;
	}
 
}
