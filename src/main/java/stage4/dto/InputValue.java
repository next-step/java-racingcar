package stage4.dto;

public class InputValue {
    private final String[] carNames;
    private final int tryNum;

    public InputValue(String[] carNames, int tryNum) {
        this.carNames = carNames;
        this.tryNum = tryNum;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryNum() {
        return tryNum;
    }
}
