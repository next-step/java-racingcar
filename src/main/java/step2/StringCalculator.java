package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public Integer splitAndSum(String text) {
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
}
