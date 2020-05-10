package racingcar;

public class Car {

    private int position;
    private Movable movable;

    public Car(int position, Movable movable) {
        this.position = position;
        this.movable = movable;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += movable.move();
    }
}
