package game.domain;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(String name, int distance) {
        this.name = new Name(name);
        this.distance = new Distance(distance);
    }

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance(1);
    }

    public void move(int number) {
        this.distance.move(number);
    }

    public String getName() {
        return this.name.toString();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, distance);
    }
}
