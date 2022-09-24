package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    static String Delimiter = ",|:";

    public static int sum(String value) {
        if(isBlankOrisNull(value))
            return 0;

        if(isDigit(value)){
            return Integer.parseInt(value);
        }

        if(value.substring(0,2).equals("//")) {
            return isCustom(value);
        }

        int result = 0;
        int[] numbers = split(value);
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isDigit(String value) {
        boolean isDigit = true;
        for(int i = 0; i< value.length(); i++){
            if(!Character.isDigit(value.charAt(i))){
                isDigit = false;
            }
        }
        return isDigit;
    }

    private static int isCustom(String value) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        int sum = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            for (String token : tokens) {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
    }

    private static boolean isBlankOrisNull(String value) {
        return value == "" || value == null;
    }

    public static int[] split(String value) {
        String[] values = value.split(Delimiter);
        int[] numbers = new int[values.length];
        for (int i=0; i < values.length; i++){
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String values) {
        int num = Integer.parseInt(values);
        if(!Character.isDigit(values.charAt(0)) || num < 0 ) {
            throw new RuntimeException("숫자 이외의 값 또는 음수는 입력될 수 없습니다.");
        }
        return num;
    }
}
