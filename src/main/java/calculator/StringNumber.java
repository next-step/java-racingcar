package calculator;

public class StringNumber {
    private int number;
    private static final int min = 0;
    private static final int max = 9;

    public StringNumber(String input) {
        number = Integer.parseInt(input);
        if (number < min || number > max) {
            throw new RuntimeException();
        }
    }

    public int getNumber() {
        return number;
    }
}
