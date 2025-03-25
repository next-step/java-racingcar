package racingcar;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String input) {
        this.name = new Name(input);
        this.position = new Position();
    }

    public void move(int distance) {
        position.increase(distance);
    }

    public String name() {
        return this.name.toString();
    }

    public int position() {
        return this.position.value();
    }

    public boolean sameOf(int position) {
        return this.position.value() == position;
    }
}
