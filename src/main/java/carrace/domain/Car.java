package carrace.domain;


public class Car {
    private static final int MIN_FORWARD_NUMBER = 4;
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public Car() {
        position = 1;
    }

    private boolean canMoveForward(int randomNumber) {
        return randomNumber >= MIN_FORWARD_NUMBER;
    }

    public void tryToMoveForward(RacingRule racingRule) {
        int generateNumber = racingRule.generateNumber();
        if (canMoveForward(generateNumber)) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < position; i++) {
            result.append("-");
        }

        return result.toString();
    }
}
