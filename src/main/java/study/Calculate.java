package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculate {

    public static final String BASE_REGEX = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.)\\n(.*)$", Pattern.DOTALL);

    public int calculate(String input){
        if (isEmpty(input)) return 0;
        if (isOneWord(input)) return parseInt(input);

        if (isCustomRegex(input)) {
            return summery(customSplit(input));
        }
        return summery(split(input, BASE_REGEX));
    }

    private boolean isEmpty(String input){
        return input == null || input.isEmpty();
    }

    private boolean isOneWord(String input){
        return input.length() == 1;
    }

    private String[] split(String input, String regex){
        return input.split(regex);
    }

    private String[] customSplit(String input){
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (!m.matches()) throw new RuntimeException("custom regex error");

        String custom = m.group(1);
        String numbers = m.group(2);
        String delimiter = buildDelimiterRegex(custom);

        return numbers.split(delimiter);
    }

    private String buildDelimiterRegex(String customOneChar){
        return "(?:" + BASE_REGEX + "|" + Pattern.quote(customOneChar) + ")";
    }

    private boolean isCustomRegex(String input){
        return CUSTOM_PATTERN.matcher(input).matches();
    }

    private int summery(String[] tokens){
        int sum = 0;
        for (String t : tokens){
            sum = sum(sum, parseInt(t));
        }
        return sum;
    }

    private int parseInt(String input){
        try{
            int n = Integer.parseInt(input);
            if (n < 0) throw new RuntimeException("minus number error");
            return n;
        } catch (NumberFormatException e){
            throw new RuntimeException("parse error");
        }
    }

    private int sum(int a, int b){
        return a + b;
    }
}
