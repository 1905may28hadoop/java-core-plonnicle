package com.revature.eval.java.core;

import java.util.*;
//import java.util.Map;

public class EvaluationService {

	// Submit by committing, following README.md

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) { // DONZO

		// TODO Write an implementation for this method declaration
		String acronym = new String(); // The string can only be three letters
										// long
		acronym += phrase.substring(0, 1); // Set first letter of acronym to
											// first letter of phrase
		for (int i = 1; i < (phrase.length()); i++) { // Move through the string
			switch (phrase.substring(i, i + 1)) {
			case " ":
				acronym += phrase.substring(i + 1, i + 2);
				break;
			case ",":
				acronym += phrase.substring(i + 2, i + 3);
				i++;
				break;
			case "-":
				acronym += phrase.substring(i + 1, i + 2);
				break;
			}
		}
		acronym = acronym.toUpperCase();
		// System.out.println(acronym);

		// Take phrase
		// Start with the first letter, logging it into an acronym array
		// For each subsequent space, log the next letter as into the acronym
		// array
		// Return acronym string
		return acronym;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G =
	 * 2; B, C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10;
	 * Examples "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for
	 * G, 1 point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) { // DONZO
		// TODO Write an implementation for this method declaration
		int total = 0;
		string = string.toUpperCase();
		// System.out.println(string);
		for (int i = 0; i < string.length(); i++) {
			switch (string.substring(i, i + 1)) {
			case "A":
			case "E":
			case "I":
			case "O":
			case "U":
			case "L":
			case "N":
			case "R":
			case "S":
			case "T":
				total += 1;
				break;
			case "D":
			case "G":
				total += 2;
				break;
			case "B":
			case "C":
			case "M":
			case "P":
				total += 3;
				break;
			case "F":
			case "H":
			case "V":
			case "W":
			case "Y":
				total += 4;
				break;
			case "K":
				total += 5;
				break;
			case "J":
			case "X":
				total += 8;
				break;
			case "Q":
			case "Z":
				total += 10;
				break;
			default:
				total += 0;
			}
		}
		return total;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS
	 * messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system
	 * used by many countries in North America like the United States, Canada or
	 * Bermuda. All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering
	 * Plan Area code, commonly known as area code, followed by a seven-digit
	 * local number. The first three digits of the local number represent the
	 * exchange code, followed by the unique four-digit number which is the
	 * subscriber number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by
	 * removing punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all
	 * produce the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) { // DONZO
		// TODO Write an implementation for this method declaration
		String output = "";
		// Get string
		// Delete spaces, parentheses, periods and hyphens.

		for (int i = 0; i < string.length(); i++) {
			switch (string.substring(i, i + 1)) {
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				output += string.substring(i, i + 1);
				break;
			default:
				System.out.println(string.substring(i, i + 1));
				break;
			}
		}

		if (output.length() != 10) {
			throw new IllegalArgumentException("Number too long.");
		}
		return output;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) { //DONZO
		Map<String, Integer> wordMap = new HashMap<>();
		int count = 1;
		if(!(string.contains(" ") || string.contains(",")) || string.contains("\\n")){
			wordMap.put(string, 1);
		}else{
			String[] words = string.replaceAll("[^A-Za-z]", " ").split("\\s+");
			for(int i = 0; i < words.length; i++){
				if(wordMap.containsKey(words[i])){
					count++;
					wordMap.replace(words[i], count);
				}else{
					wordMap.put(words[i], 1);
				}
			}
		}
		return wordMap;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted
	 * list of word definitions. Given a word, one can find its definition. A
	 * telephone book is a sorted list of people's names, addresses, and
	 * telephone numbers. Knowing someone's name allows one to quickly find
	 * their telephone number and address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say)
	 * a binary search will require far fewer comparisons than a linear search,
	 * but it imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm
	 * finds the position of a specified input value (the search "key") within
	 * an array sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key
	 * value of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index,
	 * or position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then
	 * the algorithm repeats its action on the sub-array to the left of the
	 * middle element or, if the search key is greater, on the sub-array to the
	 * right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be
	 * found in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration,
	 * so locating an item (or determining its absence) takes logarithmic time.
	 * A binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		
		Integer addOn = 0;
		int rollCount = 0;
		
		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			Integer index = 0;
			Integer indexMid = this.getSortedList().size() / 2;
			
			if(this.getSortedList().size() % 2 == 0){
				System.out.println("Original List: " + this.getSortedList());
				System.out.println(sortedList.get(indexMid));
				if(Integer.parseInt(t.toString()) == Integer.parseInt(sortedList.get(indexMid).toString())){
					System.out.println("t has been found!");
					index = addOn;
					System.out.println(index);
				}else if(Integer.parseInt(t.toString()) < Integer.parseInt(sortedList.get(indexMid).toString())){ //Search first half
					System.out.println(Integer.parseInt(t.toString()) + " is smaller than " + Integer.parseInt(this.getSortedList().get(indexMid).toString()));
					sortedList = sortedList.subList(0, indexMid);
					addOn += indexMid+1;
					System.out.println(indexMid);
					return BinarySearch.this.indexOf(t);
				}else{ //Search second half
					System.out.println(Integer.parseInt(t.toString()) + " is bigger than " + Integer.parseInt(this.getSortedList().get(indexMid).toString()));
					sortedList = sortedList.subList(indexMid, this.sortedList.size());
					addOn += indexMid+1;
					System.out.println(indexMid);
					return BinarySearch.this.indexOf(t);
				}
			}else{
				System.out.println("Original List: " + this.getSortedList());
				System.out.println(sortedList.get(indexMid));
				if(Integer.parseInt(t.toString()) == Integer.parseInt(sortedList.get(indexMid).toString())){
					System.out.println("t has been found!");
					if(rollCount == 0){
						index = indexMid;
					}else{
						index = addOn;
					}
					System.out.println(index);
				}else if(Integer.parseInt(t.toString()) < Integer.parseInt(sortedList.get(indexMid).toString())){ //Search first half
					System.out.println(Integer.parseInt(t.toString()) + " is smaller than " + Integer.parseInt(this.getSortedList().get(indexMid).toString()));
					sortedList = sortedList.subList(0, indexMid-1);
					addOn += indexMid+1;
					System.out.println(indexMid);
					rollCount++;
					return BinarySearch.this.indexOf(t);
				}else{ //Search second half
					System.out.println(Integer.parseInt(t.toString()) + " is bigger than " + Integer.parseInt(this.getSortedList().get(indexMid).toString()));
					sortedList = sortedList.subList(indexMid+1, this.sortedList.size());
					addOn += indexMid+1;
					System.out.println(indexMid);
					rollCount++;
					return BinarySearch.this.indexOf(t);
				}
			}

			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong
	 * number, because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because:
	 * 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong
	 * number, because: 154 != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some
	 * code to determine whether a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) { //DONZO
		boolean returnValue = false;
		int total = 0;
		int digitCount = 0;
		Integer inputInteger = 0;
		String inputString = "";
		// TODO Write an implementation for this method declaration
		
		//STEP 1 - Check if the number is one digit
		if(input < 10 && input > -1){
			returnValue = true;
		//STEP 2 - If not, calculate digitCount
		}else if(input >= 10){
			for(int i = 1; i < 9 ; i++){
				if((input / (Math.pow(10, i))) <= 1){ //100 causes errors?
					digitCount = i;
					break;
				}
			}
		//STEP 3 - Convert int input to String inputString
			inputInteger = input;
			inputString = inputInteger.toString();
			for(int j = 0; j < inputString.length(); j++){
				total += Math.pow((Integer.parseInt(inputString.substring(j, j+1))), digitCount);
			}
		//STEP 4 - Check if input is equal to total
			if(input == total){
				returnValue = true;
			}else{
				returnValue = false;
			}
		}
		return returnValue;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) { //DONZO
		// TODO Write an implementation for this method declaration
		List<Long> tempPrimes = new ArrayList<Long>(); //Factors
		List<Long> finalPrimes = new ArrayList<Long>(); //Prime Factors
	    for (int i = 2; i <= l; i++) {
	        if (l % i == 0){
	        	finalPrimes.add((long) i);
	        	l /= i;
	        	i--;
	        }   	
	    }
//		for(int i = 1; i < l; i++){
//			if((l % i) == 0){
//				//Test every number other than the ones in the tempPrimes array
//				tempPrimes.add((l/i));
//				calculatePrimeFactorsOf(l/i);
//				System.out.println("Test.");
//			}else{
//				finalPrimes = tempPrimes;
//			}
//		}
		System.out.println(tempPrimes);
		//finalPrimes = tempPrimes;
		return finalPrimes;
	}

	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on
	 * transposing all the letters in the alphabet such that the resulting
	 * alphabet is backwards. The first letter is replaced with the last letter,
	 * the second with the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It
	 * is a very weak cipher because it only has one possible key, and it is a
	 * simple monoalphabetic substitution cipher. However, this may not have
	 * been an issue in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional
	 * group size being 5 letters, and punctuation is excluded. This is to make
	 * it harder to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives
	 * thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			int count = 4;
			String reverseString = new String();
			string = string.replaceAll("[^A-Za-z\\d]", " "); 
			string = string.replaceAll(" ", "").toLowerCase();
			//Compare letters in the string to the key for reversal.
			
			for(int i = 0; i < string.length(); i++){
			switch(string.substring(i, i+1)){
				case "a":
					reverseString += "z";
					break;
				case "b":
					reverseString += "y";
					break;
				case "c":
					reverseString += "x";
					break;
				case "d":
					reverseString += "w";
					break;
				case "e":
					reverseString += "v";
					break;
				case "f":
					reverseString += "u";
					break;
				case "g":
					reverseString += "t";
					break;
				case "h":
					reverseString += "s";
					break;
				case "i":
					reverseString += "r";
					break;
				case "j":
					reverseString += "q";
					break;
				case "k":
					reverseString += "p";
					break;
				case "l":
					reverseString += "o";
					break;
				case "m":
					reverseString += "n";
					break;
				case "n":
					reverseString += "m";
					break;
				case "o":
					reverseString += "l";
					break;
				case "p":
					reverseString += "k";
					break;
				case "q":
					reverseString += "j";
					break;
				case "r":
					reverseString += "i";
					break;
				case "s":
					reverseString += "h";
					break;
				case "t":
					reverseString += "g";
					break;
				case "u":
					reverseString += "f";
					break;
				case "v":
					reverseString += "e";
					break;
				case "w":
					reverseString += "d";
					break;
				case "x":
					reverseString += "c";
					break;
				case "y":
					reverseString += "b";
					break;
				case "z":
					reverseString += "a";
					break;
				case "1":
					reverseString += "1";
					break;
				case "2":
					reverseString += "2";
					break;
				case "3":
					reverseString += "3";
					break;
				case "4":
					reverseString += "4";
					break;
				case "5":
					reverseString += "5";
					break;
				case "6":
					reverseString += "6";
					break;
				case "7":
					reverseString += "7";
					break;
				case "8":
					reverseString += "8";
					break;
				case "9":
					reverseString += "9";
					break;
				}
			}
			
			
			if(reverseString.length() > 5){
				for(int i = 0; i < reverseString.length(); i++){
					if(i == count){
						reverseString = reverseString.substring(0, i+1) + " " + reverseString.substring(i+1, reverseString.length());
						count += 6;
					}
				}

			}
			if(reverseString.endsWith(" ")){
				reverseString = reverseString.substring(0, reverseString.length() - 1);
			}
			System.out.println(reverseString);
			return reverseString;
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) { //DONZO
			// TODO Write an implementation for this method declaration
			int count = 1;
			String reverseString = new String();
			string = string.replaceAll("[^A-Za-z\\d]", " "); 
			string = string.replaceAll(" ", "").toLowerCase();
			//Compare letters in the string to the key for reversal.
			
			for(int i = 0; i < string.length(); i++){
			switch(string.substring(i, i+1)){
				case "a":
					reverseString += "z";
					break;
				case "b":
					reverseString += "y";
					break;
				case "c":
					reverseString += "x";
					break;
				case "d":
					reverseString += "w";
					break;
				case "e":
					reverseString += "v";
					break;
				case "f":
					reverseString += "u";
					break;
				case "g":
					reverseString += "t";
					break;
				case "h":
					reverseString += "s";
					break;
				case "i":
					reverseString += "r";
					break;
				case "j":
					reverseString += "q";
					break;
				case "k":
					reverseString += "p";
					break;
				case "l":
					reverseString += "o";
					break;
				case "m":
					reverseString += "n";
					break;
				case "n":
					reverseString += "m";
					break;
				case "o":
					reverseString += "l";
					break;
				case "p":
					reverseString += "k";
					break;
				case "q":
					reverseString += "j";
					break;
				case "r":
					reverseString += "i";
					break;
				case "s":
					reverseString += "h";
					break;
				case "t":
					reverseString += "g";
					break;
				case "u":
					reverseString += "f";
					break;
				case "v":
					reverseString += "e";
					break;
				case "w":
					reverseString += "d";
					break;
				case "x":
					reverseString += "c";
					break;
				case "y":
					reverseString += "b";
					break;
				case "z":
					reverseString += "a";
					break;
				case "1":
					reverseString += "1";
					break;
				case "2":
					reverseString += "2";
					break;
				case "3":
					reverseString += "3";
					break;
				case "4":
					reverseString += "4";
					break;
				case "5":
					reverseString += "5";
					break;
				case "6":
					reverseString += "6";
					break;
				case "7":
					reverseString += "7";
					break;
				case "8":
					reverseString += "8";
					break;
				case "9":
					reverseString += "9";
					break;
				}
			}
			
			reverseString.replaceAll("\\s+","");
			
			System.out.println(reverseString);
			return reverseString;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as
	 * an integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) { //DONZO
		// TODO Write an implementation for this method declaration
		int[] numsDuo = new int[2];
		int numCount = 0;
		int solution = 0;
		int operator = 0;
		String[] nums = string.split(" ");
		nums[nums.length-1] = nums[nums.length-1].substring(0, nums[nums.length-1].length()-1);
		//System.out.println(nums[nums.length-1]);
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i].contains("0") || nums[i].contains("1") || nums[i].contains("2") || nums[i].contains("3") || nums[i].contains("4") || nums[i].contains("5") || nums[i].contains("6") || nums[i].contains("7") || nums[i].contains("8") || nums[i].contains("9")){
				numsDuo[numCount] = Integer.parseInt(nums[i]);
				numCount++;
			}
		}
		
		System.out.println(numsDuo[0]);
		
		if(string.contains("add") || string.contains("plus")){
			solution = numsDuo[0] + numsDuo[1];
		}else if(string.contains("mult") || string.contains("times")){
			solution = numsDuo[0] * numsDuo[1];
		}else if(string.contains("div")){
			solution = numsDuo[0] / numsDuo[1];
		}else if(string.contains("sub") || string.contains("minus")){
			solution = numsDuo[0] - numsDuo[1];
		}
		
		return solution;
	}

}
