package sri;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CamelCaseMatcher {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter number of inputs: ");
		System.out.println("Enter inputs space separated: ");
		String [] inputs = reader.nextLine().split(" ");
		String pattern;
		System.out.println("Enter matching pattern:");
		pattern = reader.nextLine();
		List<String> matches = new CamelCaseMatcher().matchCamelCase(inputs,pattern);
		if(matches.size() > 0){
			System.out.println("Following matches found:");
			for(String match : matches){
				System.out.println(match);
			}
		}else {
			System.out.println("No matches found!");
		}
		reader.close();
	}

	private List<String> matchCamelCase(String[] inputs, String pattern) {
		List<String> matches = new ArrayList<>();
		for(int i=0;i<inputs.length;i++){
			if(isMatch(inputs[i],pattern)){
				matches.add(inputs[i]);
			}
		}
		return matches;
	}

	private boolean isMatch(String input, String pattern) {
		StringBuffer regexStr = new StringBuffer("^");
		char [] abbrVector =  pattern.toCharArray();
		for(char c : abbrVector){
			regexStr.append(c+"[a-z]*");
		}
		regexStr.append(".*");
		return Pattern.matches(regexStr.toString(), input);
	}

}
