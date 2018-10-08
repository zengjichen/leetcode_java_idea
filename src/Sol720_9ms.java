/**
 * Created by Administrator on 2018/9/23.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.*;
public class Sol720_9ms {
}
class Solution720_9ms {
    public String longestWord(String[] words) {
        String result = "";
        Set<String> dict = new HashSet();
        for (String word : words) {
            dict.add(word);
        }
        for (String word : words) {
            if (isBetter(word, result) && contains(dict, word)) {
                result = word;
            }
        }
        return result;
    }

    private boolean contains(Set<String> dict, String target) {
        for (int i = 1; i < target.length(); i++) {
            if (!dict.contains(target.substring(0, i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isBetter(String a, String b) {
        if (a.length() > b.length()) {
            return true;
        } else if (a.length() < b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return false;
            } else if (a.charAt(i) < b.charAt(i)) {
                return true;
            }
        }
        return true;
    }

}