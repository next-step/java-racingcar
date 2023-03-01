package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
// import org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalcuratorTest {

    List<Integer> getNumbers(List<String> input) {
        return input.stream()
                .filter(number -> number.matches("[0-9]"))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    List<String> getSigns(List<String> input) {
        return input.stream()
                .filter(number -> number.matches("[+\\-/*%]"))
                .collect(Collectors.toList());
    }

    void validateInput(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
    }

    int calc(String strInput) {
        validateInput(strInput);

        List<String> input = Arrays.asList(strInput.split(" "));

        validateNumberAndSign(input);

        List<Integer> numbers = getNumbers(input);
        List<String> signs = getSigns(input);

        return initCalcurator(numbers, signs);
    }

    private void validateNumberAndSign(List<String> input) {

        if (input.stream().filter(sign -> sign.matches("[+\\-/*%]")).count() + input.stream()
                .filter(number -> number.matches("[0-9]")).count() != input.size())
            throw new IllegalArgumentException("연산자는 +, -, *, /, % 중 입력 가능 합니다.");

        if (input.stream().filter(sign -> sign.matches("[+\\-/*%]")).count() != input.stream()
                .filter(number -> number.matches("[0-9]")).count() - 1)
            throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");

        if (input.stream().filter(number -> number.matches("[0-9]")).count() < 2)
            throw new IllegalArgumentException("숫자는 최소 2개 이상이어야 합니다.");

    }

    private int initCalcurator(List<Integer> numbers, List<String> signs) {
        int initNumber = numbers.get(0);
        numbers.remove(0);

        return numbers.stream()
                .reduce(initNumber, (result, number) -> {
                    int reduceResult = calcurator(result, signs.get(0), number);
                    signs.remove(0);
                    return reduceResult;
                });
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    int calcurator(int result, String sign, int number) {
        if (sign.equals("+"))
            return add(result, number);
        if (sign.equals("-"))
            return subtract(result, number);
        if (sign.equals("*"))
            return multiply(result, number);
        if (sign.equals("/"))
            return divide(result, number);

        return 0;
    }

    @ParameterizedTest
    @ValueSource(strings = { "2 + 3 * 4 / 2 - 3", "2 + 1", "6 / 7 + 2", "2 @ 2", "" })
    void test(String input) {

        int result;

        // assertThatThrownBy(() -> {
        // int testResult = calc(input);
        // System.out.println(testResult);
        // }).isInstanceOf(IllegalArgumentException.class);

        result = calc(input);

        System.out.println(result);
    }

}
