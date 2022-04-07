package step2;

public class Positive {

    private int positiveNumber;

    public Positive() {
        this.positiveNumber = 0;
    }

    public Positive(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new RuntimeException("음수는 안돼요~");
        }
        this.positiveNumber = positiveNumber;
    }

    public void add(Positive number) {
        this.positiveNumber += number.positiveNumber;
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }
}
