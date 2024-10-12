package racingcar.domain;

public class Car {

    private int position = 0;
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(final MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
