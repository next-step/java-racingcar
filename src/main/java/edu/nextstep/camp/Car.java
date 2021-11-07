package edu.nextstep.camp;

public class Car {
    private final Position position;

    public Car() {
        position = Position.of(0);
    }

    public Position position() {
        return position;
    }

    public void move() {
        position.forward();
    }

    public String trip() {
        return "-".repeat(position.toInt());
    }
}
