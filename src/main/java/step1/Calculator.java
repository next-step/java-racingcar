package step1;

public class Calculator {
    public static int run(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String[] inputArray = input.split(" ");

        if (inputArray.length % 2 == 0) {
            throw new IllegalArgumentException();
        }

        Number number = new Number(inputArray[0]);

        for (int i = 1; i < inputArray.length; i += 2) {
            number.operate(inputArray[i], inputArray[i + 1]);
        }

        return number.getValue();
    }

}
