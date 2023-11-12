package carracing.domain.car;

public class Car implements Comparable<Car> {

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

    @Override
    public int compareTo(Car o) {
        if (this.position.getPosition() == o.position.getPosition()) {
            return 0;
        } else if (this.position.getPosition() < o.position.getPosition()) {
            return -1;
        }
        return 1;
    }

    public boolean isSamePosition(Car car) {
        return this.position.equals(car.position);
    }

    public void move(int position) {
        this.position = this.position.move(position);
    }
}
