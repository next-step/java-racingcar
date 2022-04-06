package calculator;

public class PositiveInteger {

    private final int number;

    public PositiveInteger(String item) {
        this.number = toInt(item);
    }

    private int toInt(String item) throws RuntimeException {
        int number;

        try {
            number = Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }

    public int addSum(int sum) {
        return number + sum;
    }

}