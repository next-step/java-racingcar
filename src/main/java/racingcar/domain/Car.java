package racingcar.domain;

public class Car {
    private static final int ZERO = 0;
    private static final int BOUNDARY = 4;
    private static final String DISPLAY_UNIT = "-";

    private int position;

    public Car() {
        this.position = ZERO;
    }

    public String showStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DISPLAY_UNIT);
        }
        return stringBuilder.toString();
    }

    public void move() {
        int randomValue = RandomGenerator.getRandomValue();
        if (isMovable(randomValue)) {
            position++;
        }
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= BOUNDARY;
    }
}
