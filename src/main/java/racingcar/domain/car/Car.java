package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public void movePosition(int number) {
        if (number >= 4) {
            position.moveForward();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public int compareTo(Car o) {
        if (this.getPosition() > o.getPosition()) {
            return 1;
        }
        return 0;
    }
}
