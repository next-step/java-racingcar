package domain;

public class Calculator {

    private int number;

    public Calculator() {
        this.number = 0;
    }


    private void validationInput(String numberStr) {
        if (numberStr == null || numberStr.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 공백 문자열은 존재 할 수 없습니다.");
        }
    }

    private void validationInput(String[] numbers) {
        for (String number : numbers) {
            validationInput(number);
        }
    }


    public int calc(String input) {
        validationInput(input);

        String[] inputValues = input.split(" ");
        validationInput(inputValues);

        int numbersLength = inputValues.length;

        for (int i = 1; i < numbersLength; i += 2) {

            if (i - 1 == 0) {
                number = Integer.parseInt(inputValues[i - 1]);
            }

            Operation operation = Operation.findByInputMark(inputValues[i]);
            number = operation.calculate(number, inputValues[i + 1]);

        }

        return number;
    }

}
