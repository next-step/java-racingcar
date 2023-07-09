package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int sum(String text) {
        // 1-1. StringUtil - 텍스트를 분리
        String[] strings = StringUtil.split(text);

        // 1-2. StringUtil - 숫자(String type)를 숫자(int type)으로 변환
        List<Integer> numbers = Arrays.stream(strings)
            .map(StringUtil::toInt)
            .collect(Collectors.toList());

        // 2. Positive - 숫자를 Positive 객체 리스트로 리턴
        List<Positive> positiveNumbers = numbers.stream()
            .map(Positive::new)
            .collect(Collectors.toList());

        // 3. Calculator - 숫자들의 합을 반환
        return positiveNumbers.stream()
            .map(positiveNumber -> positiveNumber.getNum())
            .reduce((i1, i2) -> i1 + i2).get();
    }
}
