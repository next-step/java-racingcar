package calculator;

public class Calculator {

    public int calculate(String formula) {

        if (isEmpty(formula)) {
            throw new IllegalArgumentException();
        }

        String[] array = formula.split(" ");
        int result = 0;

        for (int i = 0; i < array.length - 1; i += 2) {
            int first = isFirst(i) ? Integer.parseInt(formula.split(" ")[i]) : result;
            String operator = formula.split(" ")[i+1];
            int second = Integer.parseInt(formula.split(" ")[i+2]);

            result = calculate(first, operator, second);
        }

        return result;
    }

    private boolean isFirst(int i) {
        return i == 0;
    }

    private boolean isEmpty(String formula) {
        return "".equals(formula) || " ".equals(formula) || formula == null;
    }

    public int calculate(int first, String operation, int second) {
        if ("+".equals(operation)) {
            return first + second;
        } else if ("-".equals(operation)) {
            return first - second;
        } else if ("*".equals(operation)) {
            return first * second;
        } else if ("/".equals(operation)) {
            return first / second;
        }

        return -1;
    }


}
