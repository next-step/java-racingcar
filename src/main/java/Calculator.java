public class Calculator {

    private final String DELIMITER = " ";


    public int calculator(String expression) {
        validate(expression);

        String[] inputs = expression.split(DELIMITER);

        int index = 0;
        int sum = Integer.parseInt(inputs[0]);
        for (String input : inputs) {
            sum = calculate(input, sum, Integer.parseInt(inputs[index+1]));
            index++;
        }

        return sum;
    }

    public int calculate(String operator, int x, int y) {
        switch (operator) {
            case "+":
                return plus(x, y);
            case "-":
                return minus(x, y);
            case "*" :
                return multiple(x, y);
            case "/":
                return divide(x, y);
            default:
                throw new IllegalArgumentException();

        }
    }

    public void validate(String input) {
        if (input.isEmpty() || input.trim().equals("")) {
            throw new IllegalArgumentException();
        }
    }


    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multiple(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }
}
