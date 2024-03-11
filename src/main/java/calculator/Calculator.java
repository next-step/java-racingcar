package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int calculate(String text) {

        if (isBlank(text)) {
            return 0;
        }

        String[] split = split(text);

        isMinus(split);

        return sum(toInts(split));
    }

    private static void isMinus(String[] texts) {
        for (String text : texts) {
            if (Integer.parseInt(text) < 0) {
                throw new RuntimeException();
            }
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        return getText(text).split(getDelimiter(text));
    }

    private static String getDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if( m.find() ){
            return m.group(1);
        }
        return ",|:";
    }

    private static String getText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if( m.find() ){
            return text.replace("//"+m.group(1)+"\n" , "" );
        }
        return text;
    }

    private static int[] toInts(String[] split) {

        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        return ints;
    }

    private static int sum(int[] numbers) {

        int result = 0;
        for (int n : numbers) {
            result += n;
        }
        return result;
    }


}
