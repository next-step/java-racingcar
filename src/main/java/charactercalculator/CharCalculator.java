package charactercalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharCalculator {
    private String text;
    private Matcher m;

    //    static List<String> expressionList = Arrays.asList(":",",");
    public CharCalculator(String input) {
        this.text = input;
        // 생성자 생성될 때만 한번 선언하게 리펙토링
        if(!isEmpty(input)){
            m = Pattern.compile("//(.)\n(.*)").matcher(this.text);
        }
    }
    public CharCalculator() {
    }


    public int calculate() {
        int result = 0;
        if(isEmpty(text)){
            return 0;
        }
        return getResult(result);
    }

    private boolean isEmpty(String text) {
        return "".equals(text) || text == null;
    }

    private int getResult(int result) {
        String customSeparator = getSeparator();
        String[] numberStrings = this.text.split(customSeparator);
        for (String numberString : numberStrings) {
            result += getNumber(numberString);
        }
        return result;
    }

    private String getSeparator() {
        String customSeparator = ",|:";
        if(m.find()){
            customSeparator = m.group(1);
            this.text = m.group(2);
        }
        return customSeparator;
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