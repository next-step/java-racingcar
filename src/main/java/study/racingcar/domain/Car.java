package study.racingcar.domain;

public class Car {
    private String name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
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
        return new Car(name, position.getPosition());
    }
}
