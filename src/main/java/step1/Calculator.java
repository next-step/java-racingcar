package step1;

public class Calculator {
    private static Calculator instance = new Calculator();

    private Calculator() {}

    public static Calculator of() {
        return instance;
    }

    public int calculate(final String input) {
        assertInput(input);

        final String[] data = input.split(" ");

        int result = Integer.parseInt(data[0]);

        for (int i = 1; i < data.length; i += 2) {
            OperatorType operator = OperatorType.findByOperatorName(data[i]);
            result = operator.calculate(result, Integer.parseInt(data[i + 1]));
        }

        return result;
    }

    private void assertInput(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input 값이 정상적이지 않습니다.");
        }
    }

}
