package step3and4.ui;

public class InputRequestByStep3 {
    private final int carNumber;
    private final int tryNumber;

    public InputRequestByStep3(int carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
