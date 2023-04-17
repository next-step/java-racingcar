package study;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public final int ZERO = 0;
    public final String DELIMITER = ",|:";

    public final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public int numberStringSum(String numberString) {
        if (isaBlank(numberString)) {
            return ZERO;
        }
        return sum(toInts(split(numberString)));
    }

    private String[] split(String numberString) {
        Matcher m = pattern.matcher(numberString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(DELIMITER + "|" + customDelimiter);
        }
        return numberString.split(DELIMITER);
    }

    private boolean isaBlank(String numberString) {
        return numberString == null || numberString.isBlank();
    }

    private List<Integer> toInts(String[] splitNumberString) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < splitNumberString.length; i++) {
            int number = toInt(splitNumberString[i]);
            numbers.add(number);
        }
        return numbers;
    }

    private int toInt(String splitNumberString) {
        int number = Integer.parseInt(splitNumberString);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private int sum(List<Integer> numbers) {
        int result = ZERO;
        for (int i : numbers) {
            result += i;
        }
        return result;
    }
}
