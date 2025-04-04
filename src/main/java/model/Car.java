package model;

public class Car {
    private int position;
    private final  String name;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }

    public void move(MoveStrategy condition) {
        if (condition.isMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
