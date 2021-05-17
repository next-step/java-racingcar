package calculator;

public class Calculator {
    boolean isStringDouble(String toString) {
        try {
            Double.parseDouble(toString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String[] array = {"+", "-", "*", "/"};

    int calculatorInput(String sentence) {
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(sentence)) {
                idx = i;
            }
            ;
        }/*
        boolean actualValue = numbers.contains(input);
        org.assertj.core.api.Assertions.assertThatCode(() -> {
            assertEquals(false,actualValue);
        });b
        */
        return idx;
    }

    int plus(int number1, int number2) {
        return number1 + number2;
    }

    int minus(int number1, int number2) {
        return number1 - number2;
    }

    int multiply(int number1, int number2) {
        return number1 * number2;

    }

    int divide(int number1, int number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException();
        }
        return number1 / number2;
    }

}
