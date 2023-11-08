package carracing.domain.car;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = Name.from(name);
        this.position = Position.startPosition();
    }

    public Car(String name, int position) {
        this.name = Name.from(name);
        this.position = new Position(position);
    }

    public String getName() {
        return this.name.getName();
    }

    public Integer getPosition() {
        return this.position.getPosition();
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public void move(int position) {
        this.position = this.position.move(position);
    }
}
