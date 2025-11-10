package step2;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

    public static final String COSTUME_REGEX = "//(.)\n(.*)";
    public static final String REGEX = "[,:]";

    public static int calculate(String text) {
        if (isEmpty(text)) {
            return 0; // 요구1
        }
        return sum(parser(match(text)));
    }

    private static String[] match(String text){
        Matcher m = Pattern.compile(COSTUME_REGEX, Pattern.DOTALL).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String body = m.group(2);

            if (isEmpty(body)) {
                return new String[]{};
            }
            String combined = "(?:" + REGEX + "|" + Pattern.quote(customDelimiter) + ")";
            return body.split(combined);
        }

        return text.split(REGEX);
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    private static int sum(int[] values) {
        int result = 0;
        for (int v : values) {
            result = sum(result, v);
        }
        return result;
    }

    private static int sum(int a, int b){
        return a + b;
    }

    private  static int[] parser(String[] values){
        List<Integer> list = new ArrayList<>(values.length);

        for (String raw : values) {
            String v = raw == null ? "" : raw.trim();
            if (v.isEmpty()) {
                continue;
            }
            list.add(parse(v));
        }

        if (list.isEmpty()) return new int[]{};

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static int parse(String value){
        final int i;
        try {
            i = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("invalid number format");
        }

        if (i < 0) {
            throw new RuntimeException("negative number is not allowed");
        }
        return i;
    }

}
