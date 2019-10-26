package step1;

public class Number {

    private int value;

    public int getValue() {
        return value;
    }

    public Number(String num) {
        value = parseInt(num);
    }

    private void plus(int num) {
         value += num;
    }

    private void minus(int num) {
        value -= num;
    }

    private void multiply(int num) {
        value *= num;
    }

    private void divide(int num) {
        value /= num;
    }

    public void operate(String operation, String obj) {
        int num = parseInt(obj);

        Operator operator = Operator.getOperator(operation);
        switch (operator) {
            case PLUS:
                plus(num);
                return;
            case MINUS:
                minus(num);
                return;
            case MULTIPLY:
                multiply(num);
                return;
            case DIVIDE:
                divide(num);
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }
}
