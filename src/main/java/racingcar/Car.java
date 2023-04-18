package racingcar;

public class Car implements Comparable<Car> {

    private static final int MOVABLE_COUNT = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int number) {
        if (movable(number)) {
            position.move();
        }
    }

    private boolean movable(int number) {
        return number >= MOVABLE_COUNT;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.getPosition() - o.position.getPosition();
    }
}
