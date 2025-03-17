package racingcar;

public class Car {

    private int movableThreshold = 4;

    private int position;

    public Car(int movableThreshold) {
        this.movableThreshold = movableThreshold;
    }

    public void moveOrStop(int randomInt, int distance) {
        if (isMovable(randomInt)) {
            position += distance;
        }
    }

    private boolean isMovable(int randomInt) {
        return randomInt >= movableThreshold;
    }

    public int getPosition() {
        return position;
    }

    public String getTrace(String marker) {
        StringBuilder trace = new StringBuilder();
        int position = this.getPosition();

        for (int i = 0; i < position; i++) {
            trace.append(marker);
        }

        return trace.toString();
    }
}
