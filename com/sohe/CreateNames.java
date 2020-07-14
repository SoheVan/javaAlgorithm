package com.sohe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CreateNames {
	static int k = 0; 
	static List<String> words = new ArrayList<>();
	static Set<String> wordsSet;
	public static void main(String[] args) {
		//List<String> names = CreateNames.getAll(7);
		/*for (String name : names){
			System.out.println("name "+ name);
		}*/
		//System.out.println("names.size() "+ names.size());
		
		//String str = "kaspman"; 
	    //int k = 7; 
	    //System.out.println(findPermutation(str, k)); 
		
	    String s = "kaspman"; 
        printDistinctPermutn(s, ""); 
       // System.out.println("k " + k);
        for (String name : words){
			System.out.println("name "+ name);
			
		}
        getDictionary();
        for (String name : words){
        	if(wordsSet.contains(name))
        	System.out.println("name "+ name+ " - " + wordsSet.contains(name));
			
		}
        

	}
	
	public static List<String> getAll(int length) {
	    final char[] chars = "kaspman".toCharArray();
	    final double NUMBER_OF_PERMUTATIONS = Math.pow(chars.length, length);

	    List<String> words = new ArrayList<>(Double.valueOf(
	            NUMBER_OF_PERMUTATIONS).intValue());

	    char[] temp = new char[length];
	    Arrays.fill(temp, '0');

	    for (int i = 0; i < NUMBER_OF_PERMUTATIONS; i++) {
	        int n = i;
	        for (int k = 0; k < length; k++) {
	            temp[k] = chars[n % chars.length];
	            List tempList = Arrays.asList(temp);

	            if(tempList.contains(temp[k])){
	                break;
	            }
	            n /= chars.length;
	        }
	        //System.out.println("temp "+ String.valueOf(temp));
	        //System.exit(0);
	        words.add(String.valueOf(temp));
	    }
	    System.out.println("words.size() "+ words.size());
	    return words;
	} 
	
	static int findPermutation(String str, int k) 
	{ 
	    boolean[] has = new boolean[26]; 
	    char[] word = new char[7]; 
	    Arrays.fill(has,false); 
	    List<String> words = new ArrayList<>();
	    // To store the count of distinct characters in str 
	    int cnt = 0; 
	  
	    // Traverse str character by character 
	    for (int i = 0; i < str.length(); i++) { 
	  
	        // If current character is appearing 
	        // for the first time in str 
	    	System.out.println("str.charAt(i)"+ str.charAt(i) );
	        if (!has[str.charAt(i) - 'a'])  
	        { 
	  
	            // Increment the distinct character count 
	            cnt++; 
	            System.out.println("has "+ has[str.charAt(i) - 'a']);
	            // Update the appearance of the current character 
	            has[str.charAt(i) - 'a'] = true;
	            
	            
	        } 
	    } 
	  
	    int ans = 1; 
	  
	    // Since P(n, r) = n! / (n - r)! 
	    for (int i = 2; i <= cnt; i++) 
	        ans *= i; 
	    System.out.println("ans "+ ans);
	    for (int i = cnt - k; i > 1; i--) 
	        ans /= i; 
	    System.out.println("ans "+ ans);
	    // Return the answer 
	    return ans; 
	} 
	
	static void printDistinctPermutn(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {

			// print ans
			//System.out.println(ans + " ");
			words.add(ans);
			k++;
			return;
		}

		// Make a boolean array of size '26' which
		// stores false by default and make true
		// at the position which alphabet is being
		// used
		boolean alpha[] = new boolean[26];

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// If the character has not been used
			// then recursive call will take place.
			// Otherwise, there will be no recursive
			// call
			if (alpha[ch - 'a'] == false)
				printDistinctPermutn(ros, ans + ch);
			alpha[ch - 'a'] = true;
		}
	}
	
	 public static boolean check_for_word(String word) {
	        // System.out.println(word);
	        try {
	            BufferedReader in = new BufferedReader(new FileReader(
	                    "C:\\Users\\SFoladian\\Downloads\\words\\words.txt"));
	            String str;
	            while ((str = in.readLine()) != null) {
	                if (str.indexOf(word) != -1) {
	                    return true;
	                }
	            }
	            in.close();
	        } catch (IOException e) {
	        }

	        return false;
	    }
	 
	 public static void  getDictionary() 
	    {
		 	//List<String> allLines = Files.readAllLines(Paths.get("C:\\Users\\SFoladian\\Downloads\\words\\words.txt"));
	        
	        
	        try {
	        	byte[] readBytes = Files.readAllBytes(Paths.get("C:\\Users\\SFoladian\\Downloads\\words\\words.txt"));
		        String wordListContents = new String(readBytes, "UTF-8");
		        String[] words = wordListContents.split("\n");
		        wordsSet = new HashSet<>();
		        Collections.addAll(wordsSet, words);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

}
