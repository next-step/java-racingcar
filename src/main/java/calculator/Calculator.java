package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public String calculate(String input) {
        if ((input == null) || (input.isEmpty())) {
            return "0";
        }

        // 숫자 한개만 입력 시 입력값 그대로 반환
        if (isNumber(input)) {
            return input;
        }

        String[] numbers = CustomSeparator.separateNumbers(input);

        return sum(toInts(numbers)).toString();
    }

    private List<Integer> toInts(String[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            validateInputNumber(number);
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private void validateInputNumber(String number) {
        if (!isNumber(number) || Integer.parseInt(number) < 0) {
            throw new RuntimeException("음수 or 숫자 이외의 값을 입력하셨습니다.");
        }
    }

    private Integer sum(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private boolean isNumber(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d+");
    }

}
