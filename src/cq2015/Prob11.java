package cq2015;

import java.io.BufferedReader;
import java.io.FileReader;

public class Prob11{
	//Numbered group characters 
	static final char[] numberedGroupChars = {'b', 'f', 'p', 'v', 'c', 'g', 'j', 'k', 'q', 's', 'x', 'z', 'd', 't', 'l', 'm', 'n', 'r', 'h', 'w'};
	//File path
	public static final String filePath = "inputs/2015/Prob11.in.txt";
	//Class for soundex word 
	public static class SoundexWord{
		//Instance variables 
		public String soundex;
		public int amtGenerated;

		/**
		 * Takes a certain soundex generated from a word, and stores it into a string, also having a counter. If a specific soundex occurs more than once,
		 * then amtGenerated will be at a value greater than one and will be printed out.
		 *
		 * @param soundex the soundex generated from going through the word
		 */
		public SoundexWord(String soundex){
			this.soundex = soundex;
			amtGenerated = 1;
		}

		/**
		 * Retrieves the current soundex
		 *
		 * @return the soundex as a string
		 */
		public String getSoundex(){
			return soundex;
		}

		/**
		 * Retrieves the current amount of times this soundex was generated
		 *
		 * @return amount specific soundex was generated
		 */
		public int getAmtGenerated(){
			return amtGenerated;
		}

		/**
		 * Increments amtGenerated
		 */
		public void incremenetAmtGenerated(){
			amtGenerated++;
		}

		/**
		 * Returns the soundex with the amount generated following it
		 *
		 * @return soundex with amtGenerated in format "soundex amtGenerated"
		 */
		public String toString(){
			return soundex + " " + amtGenerated;
		}
		
	}
	//Main
	public static void main(String[] args){
		try {
			//New BufferedReader object
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			//Get test cases
			int T = Integer.parseInt(br.readLine());
			//Loop through test cases
			while (T-- > 0) {
				//Grab number of names that follow
				int N = Integer.parseInt(br.readLine());
				//Initialize empty array of SoundexWord type
				SoundexWord[] words = new SoundexWord[N];
				//Loop through names
				for (int i = 0; i < N; i++) {
					//Read name
					String name = br.readLine();
					/*Make conditionals for each group like so:
					Group 1: b, f, p, v
					Group 2: c, g, j, k, q, s, x, z
					Group 3: d, t
					Group 4: l
					Group 5: m, n
					Group 6: r
					Wild: h, w (wild means they match letters from any group 1-6)
					*/
					String soundex = "";
					//One for loop for each step(one extra for loop to find first letter of numbered group char)
					//Find index of first numbered group char
					int indexOfNumberedGroupChar = 0;
					for (int j = 0; j < name.length(); j++) {
						char curChar = name.charAt(j);
						if (contains(curChar)) {
							indexOfNumberedGroupChar = j;
							break;
						}
					}
					for (int j = indexOfNumberedGroupChar; j < name.length(); j++) {
						char curChar = name.charAt(indexOfNumberedGroupChar);
						char nextChar = name.charAt(j + 1);
						int curCharGroup = -1;
						int nextCharGroup = -1;
						if(!(curChar == 'h' || curChar == 'w')){

						}
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean contains(char curChar){
		for(char c: Prob11.numberedGroupChars){
			if (c == curChar){
				return true;
			}
		}
		return false;
	}
	
	public static int getGroup(char c){
		int defReturn = -1;
		if(c == 'b' || c == 'f' || c == 'p' || c == 'v'){
			return 1;
		}
		else if(c == 'c' || c == 'g' || c == 'j' || c == 'k' || c == 'q' || c == 's' || c == 'x' || c == 'z'){
			return 2;
		}
		else if(c == 'd' || c == 't'){
			return 3;
		}
		else if(c == 'l'){
			return 4;
		}
		else if(c == 'm' || c == 'n'){
			return 5;
		}
		else if (c == 'r'){
			return 6;
		}
		return defReturn;
	}
}