package racingcargame.model;

public class RacingCar {
    private static final int MOVING_CONDITION = 4;

    private final String name;
    private int step = 0;

    public RacingCar(String name) {
        checkCarNameLength(name);
        this.name = name;
    }

    private void checkCarNameLength(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVING_CONDITION) {
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
