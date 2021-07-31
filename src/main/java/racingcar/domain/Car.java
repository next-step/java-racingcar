package racingcar.domain;

public class Car {

    private MoveStrategy moveStrategy;
    private final String name;
    private int position;

    public Car(MoveStrategy moveStrategy) {
        this(moveStrategy, "unknown", 0);
    }

    public Car(MoveStrategy moveStrategy, String name) {
        this(moveStrategy, name, 0);
    }

    public Car(MoveStrategy moveStrategy, String name, int position) {
        this.moveStrategy = moveStrategy;
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
