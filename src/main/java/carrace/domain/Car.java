package carrace.domain;


public class Car {
    private static final int MIN_FORWARD_NUMBER = 4;
    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

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

    public String getRacingResult() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");

        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

}
