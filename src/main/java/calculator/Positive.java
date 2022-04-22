package calculator;

public class Positive {
    private final int number;

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalStateException();
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
