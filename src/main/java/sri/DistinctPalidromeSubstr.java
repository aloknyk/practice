package sri;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DistinctPalidromeSubstr {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the input string:");
		String input = reader.nextLine();
		reader.close();
		int noOfPalindromes = 0;
		if(null != input && input.length() > 0){
			noOfPalindromes = findDPS(input);
		}
		System.out.println("No of DPS: " + noOfPalindromes);
	}

	private static int findDPS(String input) {
		Set<String> dps = new HashSet<>();
		int inputSize = input.length();
		//add all single letters
		for(char c:input.toCharArray()){
			dps.add(c+"");
		}
		int scope = 2;
		while(scope <= inputSize){
			for(int i=0;i<=inputSize-scope;i++){
				String subStr = input.substring(i, i+scope);
				if(isPalindrome(subStr))
					dps.add(subStr);
			}
			scope++;
		}
		return dps.size();
	}
	
	private static boolean isPalindrome(String str){
		int i=0,j=str.length()-1;
		while(i<j){
			if(str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
