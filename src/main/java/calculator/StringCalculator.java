package calculator;


public class StringCalculator {
    static final int NUMBER_0 = 0;
    static final int NUMBER_1 = 1;
    static final int NUMBER_2 = 2;
    static final int NUMBER_3 = 3;

    static int calculate(String text) {
        String[] values = text.split(" ");
        int resultValue = operationDistribution(Integer.parseInt(values[NUMBER_0]), values[NUMBER_1], Integer.parseInt(values[NUMBER_2]));
        if (values.length - NUMBER_1 >= NUMBER_3)
            for (int i = NUMBER_3; i < values.length; i += NUMBER_2) {
                resultValue = operationDistribution(resultValue, values[i], Integer.parseInt(values[i + NUMBER_1]));
            }
        return resultValue;
    }

    static int operationDistribution(int startNumber, String operation, int endNumber) {
        switch (operation) {
            case "+":
                return add(startNumber, endNumber);
            case "-":
                return sub(startNumber, endNumber);
            case "/":
                return div(startNumber, endNumber);
            case "*":
                return multi(startNumber, endNumber);
        }
        return 0;
    }

    static int add(int i, int j) {
        return i + j;
    }

    static int sub(int i, int j) {
        return i - j;
    }

    static int multi(int i, int i1) {
        return i * i1;
    }

    static int div(int i, int i1) {
        return i / i1;
    }

    static void checkNull(String input) {
        if (input == null || " ".equals(input))
            throw new NullPointerException();
    }

    static int checkNumber(String input) {
        checkNull(input);
        return Integer.parseInt(input);
    }
}
