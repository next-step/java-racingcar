package calculator;

public class Positive {
    private int number;

    public Positive(int number) {
        this.number = number;
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public Positive(String value) {
        this(Integer.parseInt(value));
    }

    public Positive add(Positive positive) {
        return new Positive(this.number + positive.number);
    }

    public int getNumber() {
        return number;
    }
}
