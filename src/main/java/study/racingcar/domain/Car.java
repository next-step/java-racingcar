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

    public int addPosition(int distance) {
        return position.getPosition() + distance;
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
}
