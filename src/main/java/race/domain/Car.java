package race.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void move(int number) {
        if (4 <= number) {
            this.position.moveForward();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
