package step3and4.ui;


import java.util.Arrays;

public class InputRequest {
    private final String[] carNumber;
    private final int tryNumber;

    public InputRequest(String[] carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
    }

    public String[] getCarNames() {
        return this.carNumber;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
