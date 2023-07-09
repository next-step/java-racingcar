package calculator;

import java.util.List;
import java.util.stream.Collectors;

public final class Calculator {

    public static int sum(String text) {
        // 1. StringUtil - 텍스트를 숫자 리스트로 변환
        List<Integer> Integers = StringUtil.convertTextToIntegers(text);

        // 2. Positive - 숫자를 Positive 객체 리스트로 리턴
        List<Positive> positiveNumbers = Integers.stream()
            .map(Positive::new)
            .collect(Collectors.toList());

        // 3. Calculator - 숫자들의 합을 반환
        return positiveNumbers.stream()
            .mapToInt(Positive::getNum)
            .sum();
    }
}
