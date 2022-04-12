package step2;

public class PositiveNumber {

    private int positiveNumber;

    public PositiveNumber(int positiveNumber) {
        if (positiveNumber < 0) {
            throw new RuntimeException("음수는 안돼요~");
        }
        this.positiveNumber = positiveNumber;
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }
}
