package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Calculatable {
    String INVALID_INPUT_EXCEPTION = "문자열 계산기에 숫자 이외의 값 또는 음수가 전달 될 수 없습니다.";

    static List<Integer> stringArrayToList(String[] tokens) {
        return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
    }

    void validateInput(String input) throws IllegalArgumentException;

    List<Integer> parseInput(String input);
}
