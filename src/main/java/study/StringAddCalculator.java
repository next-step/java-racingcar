package study;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final int ZERO = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;

    public int splitAndSum(String input) {
        if (isNotValidValue(input)) {
            return ZERO;
        }
        return sumIntArr(convertToNumberArray(splitString(input)));
    }

    private boolean isNotValidValue(String input) {
        if (Objects.isNull(input) || "".equals(input)) {
            return true;
        }
        return false;
    }

    // 문장 나누기 하기
    private String[] splitString(String input) {
        String delimiter = DELIMITER;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        if (isPatternMatch(matcher)) {
            delimiter = changeDelimiter(matcher);
            input = changeInput(matcher);
        }

        return input.split(delimiter);
    }

    // 패턴 맞는지 확인하기
    private boolean isPatternMatch(Matcher matcher) {
        return matcher.find();
    }

    // 패턴값 변경하기.
    private String changeDelimiter(Matcher matcher) {
        return matcher.group(FIRST);
    }

    // 입력값 변경하기
    private String changeInput(Matcher matcher) {
        return matcher.group(SECOND);
    }

    // 문장배열 숫자 배열로 변경하기
    private int[] convertToNumberArray(String[] strings) {
        int [] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            throwExceptionIfNegative(arr[i]);
        }
        return arr;
    }

    // 음수값이면 예외 발생
    void throwExceptionIfNegative(int input) {
        if (input < 0) {
            throw new RuntimeException("음수가 입력되었습니다. 입력숫자를 확인해주세요.");
        }
    }

    // 숫자배열 합치기.
    private int sumIntArr(int[] arr) {
        return Arrays.stream(arr).sum();
    }
}
