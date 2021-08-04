package step5.view.input;

public class Input {
    private final String[] carNames;
    private final int tryLimit;

    public Input(String[] carNames, int tryLimit) {
        this.carNames = carNames;
        this.tryLimit = tryLimit;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getTryLimit() {
        return tryLimit;
    }
}
