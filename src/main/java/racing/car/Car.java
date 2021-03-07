package racing.car;

public class Car {

    private final Movement movement;
    private int location = 0;

    public Car(Movement movement) {
        this.movement = movement;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location += movement.move();
    }

}
