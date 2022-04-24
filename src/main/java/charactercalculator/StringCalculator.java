package charactercalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String input;
    private Matcher matcher;
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

//    static List<String> expressionList = Arrays.asList(":",",");
    public StringCalculator(String input) {
        this.input = input;
        // 생성자 생성될 때만 한번 선언하게 리펙토링
        if(!isEmpty(input)){
            matcher = pattern.matcher(this.input);
        }
    }
    public StringCalculator() {
    }

    public int calculate() {
        int result = 0;
        if(isEmpty(input)){
            return 0;
        }
        return getResult(result);
    }

    private boolean isEmpty(String input) {
        return "".equals(input) || input == null;
    }

    private int getResult(int result) {
        String customSeparator = getSeparator();
        String[] numberStrings = this.input.split(customSeparator);
        for (String numberString : numberStrings) {
            result += getNumber(numberString);
        }
        return result;
    }

    private String getSeparator() {
        if(matcher.find()){
            this.input = matcher.group(2);
            return matcher.group(1);
        }
        return ",|:";
    }

    private int getNumber(String numberString) {
        int result = Integer.parseInt(numberString);
        if(isMinus(result)) {
            throw new RuntimeException("양수를 입력해야 합니다.");
        }
        return result;
    }

    private boolean isMinus(int result) {
        return result < 0;
    }
}
