package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    int calc(String strInput) {
        List<String> input = Arrays.asList(strInput.split(" "));
        List<Integer> numbers = getNumbers(input);
        List<String> signs = getSigns(input);

        return initCalcurator(numbers, signs);
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

    int calcurator(int result, String sign, int number) {
        switch (sign) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                result /= number;
                break;
            default:
                break;
        }
        return result;
    }

    @ParameterizedTest
    @ValueSource(strings = { "2 + 3 * 4 / 2 - 3", "2 + 1", "6 / 7 + 2" })
    void test(String input) {

        int result = calc(input);

        System.out.println(result);
    }

}
