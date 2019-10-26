package step1;

public class Calculator {
    public int run(String input) {

        validateInputString(input);

        String[] inputArray = changeInputStringToArray(input);

        Number number = operate(inputArray);

        return number.getValue();
    }

    private void validateInputString(String input) {
        if (input == null || input.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private String[] changeInputStringToArray(String input) {

        String[] inputArray = input.split(" ");

        if (inputArray.length % 2 == 0) {
            throw new IllegalArgumentException();
        }

        return inputArray;
    }

    private Number operate(String[] inputArray) {
        Number number = new Number(inputArray[0]);

        for (int i = 1; i < inputArray.length; i += 2) {
            number.operate(inputArray[i], inputArray[i + 1]);
        }
        return number;
    }

}
