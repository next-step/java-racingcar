package racingcargame.model;

public class RacingCar {
    private static final int MOVING_CONDITION = 4;
    private static final int MAX_LENGTH_OF_NAME = 5;
    private final String name;
    private int step;

    public RacingCar(String name) {
        checkCarNameLength(name);
        this.name = name;
        this.step = 0;
    }

    private void checkCarNameLength(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public void move(int number) {
        if (number >= MOVING_CONDITION) {
            step += 1;
        }
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
