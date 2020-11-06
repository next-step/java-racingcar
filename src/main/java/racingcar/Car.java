package racingcar;

public class Car {

    public static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.position = INITIAL_POSITION;
        this.name = name;
    }

    public void move(RuleStrategy ruleStrategy) {
        position += ruleStrategy.getMovement();
    }

    public int getPosition() {
        return position;
    }
}
