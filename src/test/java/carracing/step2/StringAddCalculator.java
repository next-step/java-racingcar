package carracing.step2;

import java.util.StringTokenizer;

public class StringAddCalculator {
    public static int splitAndSum(String originText) {
        String text = originText;
        if (text == null || text.isEmpty()) {
            return 0;
        }

        StringBuilder delim = new StringBuilder(",:");
        if(text.charAt(0) == '/') {
            text = text.substring(getStartIdxAndDelim(text, delim));
        }

        StringTokenizer tokens = new StringTokenizer(text, delim.toString());
        int result = 0;
        while (tokens.hasMoreTokens()) {
            int number = getNumber(tokens);
            result += number;
        }

        return result;
    }

    private static int getStartIdxAndDelim(String text, StringBuilder delim) {
        int idx = 2;
        while(true) {
            char c = text.charAt(idx);
            if(c == '\n') {
                idx += 1;
                break;
            }
            delim.append(c);
            idx += 1;
        }
        return idx;
    }

    private static int getNumber(StringTokenizer tokens) {
        int number = Integer.parseInt(tokens.nextToken());
        if(number < 0) {
            throw new RuntimeException("음수 발생");
        }
        return number;
    }

}
