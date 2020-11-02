package racingcar;

public class Car {
    private int position;
    private RuleStrategy ruleStrategy;

    public Car(RuleStrategy ruleStrategy) {
        position = 0;
        this.ruleStrategy = ruleStrategy;
    }

    public void move() {
        position += ruleStrategy.getMovement();
    }

    public int getPosition() {
        return position;
    }
}
