package charactercalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharCalculator {
    private String expression;

    static List<String> expressionList = Arrays.asList(":",",");
    public CharCalculator(String input) {
        this.expression = input;
    }

    public int calculate() {
        int result = 0;
        if(isEmpty(expression)){
            result = getResult(result);
        }
        return result;
    }

    private boolean isEmpty(String input) {
        return this.expression != "" || this.expression == null;
    }

    private int getResult(int result) {
        String customSeparator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.expression);
        if(m.find()){
            customSeparator = m.group(1);
            this.expression = m.group(2);
        }
        String[] numberStrings = this.expression.split(customSeparator);
        for (String numberString : numberStrings) {
            result += getNumber(numberString);
        }
        return result;
    }

    private int getNumber(String numberString) {
        int result =Integer.parseInt(numberString);
        if(isMinus(result)) {
            throw new RuntimeException("양수를 입력해야 합니다.");
        }
        return Integer.parseInt(numberString);
    }

    private boolean isMinus(int result) {
        return result < 0;
    }
}
