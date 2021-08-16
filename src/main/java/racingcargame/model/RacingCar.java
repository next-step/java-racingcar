package racingcargame.model;

import java.util.Map;

public class RacingCar {
    private static final int INITIAL_LOCATION = 0;
    private static final int MAX_LENGTH_OF_NAME = 5;
    private final String name;
    private int step;

    public RacingCar(String name) {
        checkCarNameLength(name);
        this.name = name;
        this.step = INITIAL_LOCATION;
    }

    public RacingCar(String name, int step) {
        checkCarNameLength(name);
        this.name = name;
        this.step = step;
    }

    private void checkCarNameLength(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            step += 1;
        }
    }

    public void recordHistory(Map<RacingCar, Integer> history) {
        history.put(new RacingCar(this.name, this.step), step);
    }

    public boolean isWinner(int maxScore) {
        return step == maxScore;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }
}