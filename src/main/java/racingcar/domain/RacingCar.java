package racingcar.domain;

public class RacingCar {
    private static final int MOVE_UNIT = 1;

    private String name;
    private int position;
    private Condition condition;

    public RacingCar(String name, Condition condition) {
        this.position = 0;
        this.name = name;
        this.condition = condition;
    }

    public int moveOrStop() {
        if (condition.getCondition()) {
            position += MOVE_UNIT;
        }

        return position;
    }
}
