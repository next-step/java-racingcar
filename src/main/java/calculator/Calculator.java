package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String ADDITOR = ",|:";
    private static final String NEW_OPERATOR = "//(.)\n(.*)";

    public static int calculate(String text){
        if (isBlank(text)){
            return 0;
        }

        Matcher m = Pattern.compile(NEW_OPERATOR).matcher(text);
        if (m.find()){
            return sumWithCustomizingAdditor(m);
        }

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text){
        return text == null || text.isBlank();
    }

    private static String[] split(String text){
        return text.split(ADDITOR);
    }

    private static final int NEW_ADDITOR = 1;
    private static final int SPLIT_TEXT = 2;

    private static int sumWithCustomizingAdditor(Matcher m){
        String customDelimiter = m.group(NEW_ADDITOR);
        String[] tokens = m.group(SPLIT_TEXT).split(customDelimiter);

        return sum(toInts(tokens));
    }


    private static int sum(int[] numbers) {
        int result = 0;

        for (int number : numbers){
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for (int i=0; i<values.length ; i++){
            numbers[i] = checkPositive(values[i]);;
        }
        return numbers;

    }

    private static int checkPositive(String value){
        int result = Integer.parseInt(value);
        if (result < 0){
            throw new IllegalArgumentException();
        }
        return result;
    }

}
