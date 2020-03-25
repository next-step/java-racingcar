package step4;

public class InputView {

    private int moveCount;
    private String[] cars;
    private static final String DILIMITER_COMMA = ",";

    public InputView() {
    }

    public InputView(String carNames, int moveCount) {
        validateInput(carNames);
        this.moveCount = moveCount;
        this.cars = splitCarName(carNames);
    }

    public void validateInput(String carNames) {
        if (carNames == null || "".equals(carNames.trim())) {
            throw new IllegalArgumentException();
        }
    }

    public String[] splitCarName(String carNames) {
        return carNames.split(DILIMITER_COMMA);
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String[] getCars() {
        return cars;
    }
}
