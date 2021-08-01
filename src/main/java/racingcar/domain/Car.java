package racingcar.domain;

public class Car {

    private static final MoveStrategy moveStrategy = new RacingMoveStrategy();

    private final String name;
    private int position;

    public Car() {
        this("unknown");
    }

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int bound) {
        if (moveStrategy.isMoveAble(bound)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
