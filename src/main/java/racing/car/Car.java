package racing.car;

public class Car {

    private final Movement movement;
    private final String name;
    private int location = 0;

    public Car(Movement movement, String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new CarNameException();
        }

        this.movement = movement;
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location += movement.move();
    }

    public String getName() {
        return name;
    }

}
