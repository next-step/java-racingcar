package racingGame;

public class Condition {

    private static final int STANDARD_NUMBER = 4;

    private boolean status;

    public void init(RandomNumber randomNumber) {
        status = randomNumber.generate() >= STANDARD_NUMBER;
    }

    public boolean isOk() {
        return status;
    }
}
