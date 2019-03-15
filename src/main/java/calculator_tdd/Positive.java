package calculator_tdd;

public class Positive {
    private final int number;

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }

        this.number = number;
    }
}
