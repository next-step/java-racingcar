package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public Integer splitAndSum(String text) {
        if (isNullAndEmpty(text)) {
            return 0;
        }

        String[] numbers = split(text);

        return sum(numbers);
    }

    public String[] split(String text) {
        String delimiter = ":|,";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        return text.split(delimiter);
    }

    public Integer sum(String[] numbers){
        Integer sum = 0;

        for (String number  : numbers) {
            int parseInt = Integer.parseInt(number);

            if(parseInt < 0){
                throw new IllegalArgumentException("음수는 포함할 수 없습니다.");
            }
            sum += parseInt;
        }

        return sum;
    }

    public boolean isNullAndEmpty(String text){
        if (text == null) {
            return true;
        }

        if (text.isEmpty()) {
            return true;
        }

        return false;
    }
}