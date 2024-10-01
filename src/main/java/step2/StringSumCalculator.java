package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) return 0;

        String[] numArr = splitNum(input);
        checkMinus(numArr);

        return sum(numArr);
    }

    // 요청값을 패턴에 맞게 분해하여 String[] 배열로 반환한다.
    private static String[] splitNum(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        String[] numArr;
        if (m.find()) {
            String customDelimiter = m.group(1);
            numArr = m.group(2).split(customDelimiter);
        } else { // 커스텀 표현식이 없을 시 , :로 분해
            numArr = input.split("[,:]");
        }
        return numArr;
    }

    // String[] numArr에 음수가 포함되어있는지 체크한다.
    private static void checkMinus(String[] numArr) {
        boolean check = Arrays.stream(numArr)
                .anyMatch(s -> s.contains("-"));

        if (check) throw new RuntimeException("Minus not allowed");
    }

    // String[] numArr에 포함된 값들을 더해준다.
    private static int sum(String[] numArr) {
        return Arrays.stream(numArr)
                .mapToInt(Integer::parseInt) // 각 문자열을 int로 변환
                .sum();
    }

}