package study;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private String regex = ",|:";
    private String StringInput;
    private Matcher matcher;

    public int splitAndSum(String input) {
        StringInput = input;
        setMatch(StringInput);

        if (isPatternMatch(matcher)) {
            changeRegex(matcher);
            changeStringInput(matcher);
        }

        String[] strings = splitSentences(StringInput);
        int[] arr = changeStringArrToIntArr(strings);
        return sumIntArr(arr);
    }

    // Match 셋팅
    private void setMatch(String input) {
        if (Objects.isNull(input)) {
            return;
        }
        matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
    }

    // 패턴 맞는지 확인하기
    private boolean isPatternMatch(Matcher matcher) {
        if (Objects.isNull(matcher)) {
            return false;
        }
        return matcher.find() == true ? true : false;
    }

    // 패턴값 변경하기.
    private void changeRegex(Matcher matcher) {
        regex = matcher.group(1);
    }

    // 입력값 변경하기
    private void changeStringInput(Matcher matcher) {
        StringInput = matcher.group(2);
    }

    // 문장 나누기 하기
    private String[] splitSentences(String input) {
        if (!Objects.isNull(input)) {
            return new String[0];
        }
        return input.split(regex);
    }

    // 문장배열 숫자 배열로 변경하기.
    private int[] changeStringArrToIntArr(String[] strings) {
        int [] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            if (arr[i] < 0) {
                throw new RuntimeException("음수가 입력되었습니다. 입력숫자를 확인해주세요.");
            }
        }
        return arr;
    }

    // 숫자배열 합치기.
    private int sumIntArr(int[] arr) {
        return Arrays.stream(arr).sum();
    }

}
