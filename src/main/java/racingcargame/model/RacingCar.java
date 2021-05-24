package racingcargame.model;

public class RacingCar {
    private final String name;
    private int step = 0;

    public RacingCar(String name) {
        this.name = name;
        checkCarNameLength();
    }

    public void checkCarNameLength() {
        if (this.name.length() > 5) {
            throw new NullPointerException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void move(int randomNumber) {
        int movingCondition = 4;
        if (randomNumber >= movingCondition) {
            this.step += 1;
        }
    }

    public boolean isWinner(int maxScore) {
        return step == maxScore;
    }
}
