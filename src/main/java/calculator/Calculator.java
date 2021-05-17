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


}
