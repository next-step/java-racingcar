package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");

        int first = Integer.parseInt(values[0]);
        String operator = values[1];
        int second = Integer.parseInt(values[2]);

        int result = calculate(first, operator, second);

        for (int i = 3, loop = values.length; i < loop; ) {
            operator = values[i++];
            second = Integer.parseInt(values[i++]);
            result = calculate(result, operator, second);
        }

        return result;
    }

    static int calculate(int i, String operator, int j) {
        switch (operator) {
            case "+":
                return i + j;
            case "-":
                return i - j;
            case "*":
                return i * j;
            case "/":
                return i / j;
        }

        return 0;
    }

}
