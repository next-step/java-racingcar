package carracing.domain.car;

public class Car {

    private Name name;
    private Position position;

    public Car(String name) {
        this.name = Name.from(name);
        this.position = Position.startPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    public Integer getPosition() {
        return this.position.getPosition();
    }

    public void move(int position) {
        this.position = this.position.move(position);
    }
}
