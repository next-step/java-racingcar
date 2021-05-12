public class RacingCar {
    private final String name;
    private int step = 0;

    RacingCar(String name) {
        checkCarNameLength();
        this.name = name;
    }

    public void checkCarNameLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
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
}
