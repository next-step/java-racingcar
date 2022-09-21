package step3.domain;

public class Car {
    private final Position position;

    public Car() {
        this(0);
    }

    public Car(Position position) {
        this.position = position;
    }

    public Car(int position) {
        this(new Position(position));
    }


    public Car move() {
        return new Car(position.advance());
    }

    public int state() {
        return position.value();
    }
}
