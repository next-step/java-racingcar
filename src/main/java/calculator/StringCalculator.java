package calculator;

import java.util.Objects;

public class StringCalculator {
    Double number;
    Double number2;
    Operator sign;

    public double calculate(String input) {
        checkNull(input);

        String[] splitInput = input.split(" ");
        this.number = Double.parseDouble(splitInput[0]);

        for (int i = 1; i < splitInput.length; i += 2) {
            this.number2 = Double.parseDouble(splitInput[i+1]);

           // this.number = operate(splitInput[i], this.number, this.number2);
        }

        return this.number;
    }

    private void checkNull(String input) {
        if (Objects.isNull(input) || input == " ") {
            throw new IllegalArgumentException("입력 값이 공백입니다.");
        }
    }

}

