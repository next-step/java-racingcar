package CarRacing.domain;

public class Car {
    private final Position position;
    private final CarName carname;

    public Car(String name) {
        this.carname = new CarName(name);
        this.position = new Position();
    }

    public void move(int number) {
        this.position.move(number);
    }

    public int currentPosition() {
        return position.currentPosition();
    }

    public String name() {
        return this.carname.Name();
    }
}
