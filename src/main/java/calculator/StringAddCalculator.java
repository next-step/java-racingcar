package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    //클래스 변수 선언
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern COMPILED_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    public static int splitAndSum(String text) {

        if (emptyValueReturnToZero(text)) {
            return 0;
        }
        Matcher matchedValue = COMPILED_PATTERN.matcher(text);

        if (matchedValue.find()) {
            String customDelimiter = matchedValue.group(1);
            String[] values = matchedValue.group(2).split(customDelimiter);
            return sum(toInts(values));
        }
        String[] values = text.split(DEFAULT_DELIMITER);
        return sum(toInts(values));

    }

    private static boolean emptyValueReturnToZero(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    /*
    배열보다는 리스트(제네릭)를 사용하는건 어떨까요?
    이펙티브 자바 아이템 28: 배열보다는 리스트를 사용하라를 한번 찾아보시면 좋을거 같아요.
    --> 배열오류 (런타임에서 발생) << 리스트오류(컴파일 오류) :에러를 훨씬 빨리 잡을 수 있음
     */
    private static ArrayList<Integer> toInts(String[] values) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            toInt(values[i]);
            numbers.add(Integer.parseInt(values[i]));
        }
        return numbers;
    }

    private static int sum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (0 > number) {
            throw new RuntimeException();
        }
        return number;
    }
}
