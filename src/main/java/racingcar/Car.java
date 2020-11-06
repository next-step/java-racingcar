package racingcar;

public class Car {

    public static final int INITIAL_POSITION = 0;
    private final String name;
    private final RuleStrategy ruleStrategy;
    private int position;

    public Car(String name, RuleStrategy ruleStrategy) {
        this.position = INITIAL_POSITION;
        this.name = name;
        this.ruleStrategy = ruleStrategy;
    }

    public void move() {
        position += ruleStrategy.getMovement();
    }

    public int getPosition() {
        return position;
    }
}
