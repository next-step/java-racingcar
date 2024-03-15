package game.domain;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        this.distance = new Distance(1);
    }

    public void move(int number) {
        this.distance.move(number);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
