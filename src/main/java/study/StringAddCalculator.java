package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {  // 일반 메소드
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text); // 커스텀 구분자 확인
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return addEachItem(tokens);
        }

        return addEachItem(text.split( ",|:"));
    }

    public static int getIfNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch(NumberFormatException e){
            return -1;
        }
    }

    public static void isPositive(int number) {
        if(number < 0){
            throw new RuntimeException();
        }
    }

    public static int addEachItem(String[] numbers) {
        int result = 0;
        for(String num:numbers) {
            int temp = getIfNumber(num);
            isPositive(temp);
            result += temp;
        }
        return result;
    }
}
