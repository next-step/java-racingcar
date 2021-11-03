package calculator;

public class Calculator {

    public int calculate(String input) {

        String[] split = input.split(" ");

        int first = Integer.parseInt(split[0]);
        String operation = split[1];
        int second = Integer.parseInt(split[2]);

        int result = calculate(first, operation, second);

        for (int i = 3; i < split.length; i += 2) {

            if (split.length <= i + 1) {
                throw new IllegalArgumentException("input 규격이 맞지 않습니다.");
            }

            first = result;
            operation = split[i];
            second = Integer.parseInt(split[i + 1]);

            result = calculate(first, operation, second);
        }

        return result;
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
