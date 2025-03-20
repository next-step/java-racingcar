package racingcar;

public class Car {

    private int movableThreshold = 4;

    private int position;

    public Car(int movableThreshold) {
        this.movableThreshold = movableThreshold;
    }

    public void moveOrStop(int randomInt) {
        if (isOutOfBound(randomInt)) {
            throw new IllegalArgumentException("0 부터 9 사이의 정수값만 입력 가능합니다.");
        }
        if (isMovable(randomInt)) {
            position++;
        }
    }

    private boolean isOutOfBound(int randomInt) {
        return randomInt < 0 || randomInt > 9;
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
