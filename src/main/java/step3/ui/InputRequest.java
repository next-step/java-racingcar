package step3.ui;

public class InputRequest {
    private final int carNumber;
    private final int tryNumber;

    public InputRequest(int carNumber, int tryNumber) {
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
