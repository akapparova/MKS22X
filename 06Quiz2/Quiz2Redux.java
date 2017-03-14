import java.util.ArrayList;
import java.util.Collections;

public class Quiz2Redux{
    public static ArrayList<String> combinations (String s) {
	ArrayList<String> words = new ArrayList<String>();
	words.add("");
	help(words, s, 0, "");
	Collections.sort(words);
	return words;
    }
  
    private static void help(ArrayList<String> words, String s, int i, String omw){
        if (i >= s.length()) return;
      	help(words, s, i + 1, omw);
        help(words, s, i + 1, omw + s.substring(i, i + 1));
        words.add(omw + s.substring(i, i + 1));
    } 
}
