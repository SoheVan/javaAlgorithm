package July;

import java.util.Scanner;

public class ReplaceChar {

	//base on the logic you can return a null value or an empty string
	private String replaceChar(String input, char chOne, char chTwo){
		String result ="";
		if(input == null || input.isEmpty()){
			return input;
		}
		result = input.replace(chOne, chTwo);
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String chone = sc.next();
		String chtwo = sc.next();
		
		
		ReplaceChar rc = new ReplaceChar();
		String replaced = rc.replaceChar(str, chone.charAt(0), chtwo.charAt(0));
		System.out.println("replaced= "+replaced);

	}

}
