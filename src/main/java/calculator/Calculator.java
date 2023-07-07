package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int sum(String text) {
        // 1. 텍스트를 분리
        String[] strings = StringUtil.split(text);

        // 2. 숫자(String type)를 숫자(int type)으로 변환
        List<Integer> numbers = Arrays.stream(strings)
            .map(StringUtil::toInt)
            .collect(Collectors.toList());
        List<Positive> positiveNumbers = numbers.stream()
            .map(Positive::new)
            .collect(Collectors.toList());

        // 3. 숫자들의 합을 반환
        return positiveNumbers.stream()
            .map(o -> o.getNum())
            .reduce((i1, i2) -> i1 + i2).get();
    }
}
