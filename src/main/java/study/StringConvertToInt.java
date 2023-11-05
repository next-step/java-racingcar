package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringConvertToInt {
    private static final Pattern CUSTOME_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = ",|:";
    public static int [] stringConvertToInt (String input){
        String[] texts = splitInput(input);
        int [] numbers = new int[texts.length];
        for(int i=0; i< texts.length; i++){
            numbers[i] = toInt(texts[i]);
        }
        return numbers;
    }
    private static String[] splitInput(String input) {
        Matcher m = CUSTOME_PATTERN.matcher(input);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return input.split(DELIMITER);
    }
    private static int toInt(String element) {
        try {
            int number = Integer.parseInt(element);
            if ( number < 0) {
                throw new RuntimeException("0 이상 양수만 입력 가능!!");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
