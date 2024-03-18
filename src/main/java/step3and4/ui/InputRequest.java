package step3and4.ui;


public class InputRequest {
    private final String[] carNames;
    private final int tryNumber;

    public InputRequest(String[] carNames, int tryNumber) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("차량정보가 없습니다.");
        }
        this.carNames = carNames;
        this.tryNumber = tryNumber;
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
