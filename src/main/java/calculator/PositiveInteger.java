package calculator;

public class PositiveInteger {

    private final int number;

    public PositiveInteger(String item) {
        this.number = toInt(item);
    }

    private int toInt(String item) throws RuntimeException {
        int number;

        try {
            number = Integer.parseInt(item); // isNotNumber
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        if (number < 0) { // isNegativeNumber
            throw new RuntimeException();
        }

        return number;
    }

    public int getNumber() {
        return number;
    }
}