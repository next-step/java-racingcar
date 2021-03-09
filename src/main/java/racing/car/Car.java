package racing.car;

public class Car implements ReadonlyCar {

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

    public void move() {
        location += movement.move();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLocation() {
        return location;
    }
}
