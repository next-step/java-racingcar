package calculator;

public class StringCalculator {

    static int calculate(String text) {

        if(text == null || text.isEmpty()) {
            throw new IllegalAccessError();
        }
        String[] values = text.split(" ");
        int result = Integer.parseInt(values[0]);

        for(int i = 1 ; i<values.length ; i = i + 2) {
            int value = Integer.parseInt(values[i+1]);
            result = calculate(values[i], result, value);
        }

        return result;
    }

    private static int calculate(String operation, int value1, int value2) {
        OperationType operationType = OperationType.of(operation);
        return operationType.calculate(value1, value2);
    }
}


