package calculator;

public class Positive {

    private int num;

    public Positive(int num) {
        validatePositiveNumber(num);
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    private void validatePositiveNumber(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }
}
