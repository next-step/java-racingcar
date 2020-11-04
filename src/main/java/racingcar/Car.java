package racingcar;

public class Car {

    public static final int INITIAL_POSITION = 0;
    private int position;
    private RuleStrategy ruleStrategy;

    public Car(RuleStrategy ruleStrategy) {
        this.position = INITIAL_POSITION;
        this.ruleStrategy = ruleStrategy;
    }

    public void move() {
        position += ruleStrategy.getMovement();
    }

    public int getPosition() {
        return position;
    }
}
