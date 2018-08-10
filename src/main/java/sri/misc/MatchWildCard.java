package sri.misc;

import java.util.Scanner;

public class MatchWildCard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//while(true){
			System.out.println("Enter the pattern: ");
			String patt = sc.nextLine().trim();
			System.out.println("Enter the string to be matched: ");
			String input = sc.nextLine().trim();
			matchesPattern(patt,input);
		//}
	}

	private static void matchesPattern(String patt, String input) {
		String a = patt;
		String b = input;
		boolean arr[][] = new boolean[b.length() + 1][a.length() + 1];
		arr[0][0] = true;
		if (a.charAt(0) == '*')
			arr[0][1] = true;
		for (int i = 0; i < b.length(); i++) {
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(j) == b.charAt(i) || a.charAt(j) == '?') {
					arr[i + 1][j + 1] = arr[i][j];
				} else if (a.charAt(j) == '*')
					arr[i + 1][j + 1] = arr[i][j + 1] || arr[i + 1][j];
				else
					arr[i + 1][j + 1] = false;
				printArray(arr);
			}
		}
		if (arr[b.length()][a.length()])
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	private static void printArray(boolean[][] arr){
		System.out.println();
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
