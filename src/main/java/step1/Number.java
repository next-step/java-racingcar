package step1;

public class Number {

    private int value;

    public int getValue() {
        return value;
    }

    public Number(String num) {
        try {
            value = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void plus(int num) {
         value += num;
    }

    private void minus(int num) {
        value -= num;
    }

    private void multiplied(int num) {
        value *= num;
    }

    private void divide(int num) {
        value /= num;
    }

    public void operate(String operation, String obj) {
        int num;

        try {
            num = Integer.parseInt(obj);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        switch (operation) {
            case "+":
                plus(num);
                return;
            case "-":
                minus(num);
                return;
            case "*":
                multiplied(num);
                return;
            case "/":
                divide(num);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }
}
