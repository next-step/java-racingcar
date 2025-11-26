package racingGame;

public class Car {

    private final CarName name;
    private Position position;

    public Car(String name) {
        this(new CarName(name));
    }

    Car(CarName name) {
        this.name = name;
        this.position = Position.ZERO;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMove()) {
            position = position.move();
        }
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.value();
    }

    public int max(int currentMax) {
        return position.max(currentMax);
    }
    public boolean isSame(int max) {
        return position.isSame(max);
    }
}
