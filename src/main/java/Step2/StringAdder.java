package Step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public int sum(String input) {
        String delim = "";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            delim = m.group(1);
            input = m.group(2);
        }

        int result = 0;
        String[] splits = input.split("");

        for (String s : splits) {
            result = update_result(s, delim, result);
        }

        return result;
    }

    private int update_result(String word, String delim, int result){
        if (word.isEmpty()) { return result; }
        if (is_delim(word, delim)) { return result; }

        return sum_on_word(word, result);
    }

    private boolean is_delim(String word, String delim){
        if (true != delim.isEmpty() && word.equals(delim)) { return true; }
        if (delim.isEmpty() && word.equals(",") || word.equals(":")) { return true; }

        return false;
    }

    private int sum_on_word(String word, int result){
        try {
            result += parse_int(word);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        return result;
    }

    private int parse_int(String word){
        int cur_num = Integer.parseInt(word);
        if (cur_num < 0) {
            throw new RuntimeException();
        }

        return cur_num;
    }
}
