package calculator;

public class Calculator {

    private static final String SEPARATOR = " ";

    public int calculate(String input) {
        String[] split = input.split(SEPARATOR);

        CalNumber first = new CalNumber(split[0]);
        String symbol = split[1];
        CalNumber second = new CalNumber(split[2]);

        CalNumber result = first.calculate(second, symbol);

        for (int i = 3; i < split.length; i += 2) {
            isValidLength(split, i);

            CalNumber to = new CalNumber(split[i + 1]);
            symbol = split[i];

            result = result.calculate(to, symbol);
        }

        return result.getNumber();
    }

    private void isValidLength(String[] split, int i) {
        if (split.length <= i + 1) {
            throw new IllegalArgumentException("input 규격이 맞지 않습니다.");
        }
    }

    private int calculate(int first, String operation, int second) {
        if (operation.equals("+")) {
            return first + second;
        }

        if (operation.equals("-")) {
            return first - second;
        }

        if (operation.equals("*")) {
            return first * second;
        }

        if (operation.equals("/")) {
            return first / second;
        }

        throw new IllegalArgumentException("operation이 잘못되었습니다.");
    }


}
