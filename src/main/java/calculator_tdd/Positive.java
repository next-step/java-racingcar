package calculator_tdd;

public class Positive {
    private final int number;

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Positive add(Positive positive) {
        return new Positive(this.number + positive.number);
    }
}
