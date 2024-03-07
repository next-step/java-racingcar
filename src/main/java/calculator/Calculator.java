package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String ADDITOR = ",|:";

    public static int calculate(String text){
        if(isBlank(text)){
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
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

    private static int sumWithCustomizingAdditor(Matcher m){
        String customDelimiter = m.group(1);
        String[] tokens = m.group(2).split(customDelimiter);

        return sum(toInts(tokens));
    }


    private static int sum(int[] numbers) {
        int result = 0;

        for(int number : numbers){
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i=0; i<values.length ; i++){
            numbers[i] = checkPositive(values[i]);;
        }
        return numbers;

    }

    private static int checkPositive(String value){
        int result = Integer.parseInt(value);
        if(result < 0){
            throw new RuntimeException();
        }
        return result;
    }

}
