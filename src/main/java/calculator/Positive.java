package calculator;

public class Positive {
    private final int number;

    public Positive(String str) {
        this.number = Integer.parseInt(str);
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }
}
