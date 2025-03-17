package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiter {

    public boolean hasCustomDelimiter(String s) {
        if (s.matches("//(.)\n(.*)")) {
            return true;
        }
        return false;
    }

    public String[] extractAndSplit(String s) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        throw new IllegalArgumentException("매치가 없습니다");
    }
}
