package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String source) {

        // null & 공백 판별
        if (source == null) {
            return 0;
        }
        if (source.isEmpty()) {
            return 0;
        }

        // source 의 길이가 1 일 경우 ?
        if (isOnlyOneNumber(source)) {
            return Integer.parseInt(source);
        }

        // 커스텀 구분자를 먼저 찾고
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(source);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);

            return calculateSourceItems(tokens);
        }

        // 여기로 왔다는 것은 , : 로만 구성된 문자열이란 의미

        String[] tokens = source.split(",|:");

        return calculateSourceItems(tokens);
    }

    private static boolean isOnlyOneNumber(String source) {
        if (source.length() == 1) { // 들어온 input 값이 하나다 ?
            isNotNumber(source); // 정상적인 숫자인지 확인
            isNegativeNumber(source); // 음수인지 확인
            return true; // 예외가 터지지 않았다면 너는 유일한 숫자
        }

        return false; // length 가 2 이상이면 다른 로직을 타야함.
    }

    // String[] 계산
    private static int calculateSourceItems(String[] items) throws RuntimeException{
        int sum = 0;

        for (String item : items) {
            isNotNumber(item); // 숫자가 아닌 이상한 친구가 입력됐다면 예외
            isNegativeNumber(item); // 여기로 왔다는것은 숫자긴하다는 의미
        }

        for (String item : items) {
            sum += Integer.parseInt(item);
        }
        return sum;
    }

    // 숫자가 아닌 이상한 친구를 입력했을 때
    private static void isNotNumber(String item) throws RuntimeException {
        try {
            Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    // 숫자는 맞지만 음수일 경우 Exception
    private static void isNegativeNumber(String item) throws RuntimeException {
        int itemToInteger = Integer.parseInt(item);
        if (itemToInteger < 0) {
            throw new RuntimeException();
        }
    }

}
