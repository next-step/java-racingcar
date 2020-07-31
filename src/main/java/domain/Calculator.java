package domain;

import java.util.Arrays;

public class Calculator {

    private int number;

    public Calculator() {
        this.number = 0;
    }


    private void validationInput(String numberStr) {
        if (numberStr == null || numberStr.isEmpty()) {
            throw new IllegalArgumentException("빈 공백 문자열은 존재 할 수 없습니다.");
        }
    }

    private void validationInput(String[] numbers) {
        Arrays.stream(numbers)
                .forEach(num -> validationInput(num));
    }


    public int calc(String input) {
        validationInput(input);

        String[] operator = input.split(" ");
        validationInput(operator);

        int numbersLength = operator.length;

        for (int i = 1; i < numbersLength; i += 2) {

            if (i - 1 == 0) {
                number = Integer.parseInt(operator[i - 1]);
            }

            Operation v = Operation.findByInputMark(operator[i]);
            number = v.calculate(number, operator[i + 1]);

        }

        return number;
    }

}
