package calculator;

import java.util.Objects;

import static calculator.Operator.*;

public class StringCalculator {
    Double number1;
    Double number2;

    public double calculate(String input) {
        checkNull(input);

        String[] splitInput = input.split(" ");
        number1 = Double.parseDouble(splitInput[0]);

        for (int i = 1; i < splitInput.length; i += 2) {
            number2 = Double.parseDouble(splitInput[i + 1]);
            number1 = operate(splitInput[i], number1, number2);
        }

        return this.number1;
    }

    public void checkNull(String input) {
        if (Objects.isNull(input) || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 공백입니다.");
        }
    }

    private Double operate(String sign, double number1, double number2) {
        if (sign.equals("+")) {
            return ADD.operate(number1, number2);
        }
        if (sign.equals("-")) {
            return SUBTRACT.operate(number1, number2);
        }
        if (sign.equals("*")) {
            return MULTIPLY.operate(number1, number2);
        }
        if (sign.equals("/")) {
            if (number2 == 0) {
                throw new IllegalArgumentException("몫은 0이 될 수 없습니다");
            }
            return DIVIDE.operate(number1, number2);
        }
        throw new IllegalArgumentException("사칙 연산 기호가 아닙니다");
    }

}

