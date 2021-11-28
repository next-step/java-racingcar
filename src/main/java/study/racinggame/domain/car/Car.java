package study.racinggame.domain.car;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.increase();
        }
    }

    public String name() {
        return name.getValue();
    }

    public boolean isWinner(int max) {
        return position.maximum(max);
    }

    public int position() {
        return position.getValue();
    }
}
