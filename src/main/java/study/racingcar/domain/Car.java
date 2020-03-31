package study.racingcar.domain;

public class Car {
    private String name;
    private Position position;

    public Car(String name) {
        this(name, Position.ZERO);
    }

    public Car(String name, int position) {
        this(name, new Position(position));
    }

    private Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int distance) {
        this.position.add(distance);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isPositionEqualTo(int position) {
        return this.position.getPosition() == position;
    }

    public Car clone() {
        return new Car(name, position.clone());
    }
}
