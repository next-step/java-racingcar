package racingcar.domain;

public class Car {
    private final CarMovePredicate movePredicate;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, new DefaultCarMovePredicate());
    }

    public Car(String name, int position) {
        this(name, position, new DefaultCarMovePredicate());
    }

    public Car(String name, CarMovePredicate movePredicate) {
        this(name, 0, movePredicate);
    }

    public Car(String name, int position, CarMovePredicate movePredicate) {
        this.name = name;
        this.position = position;
        this.movePredicate = movePredicate;
    }

    public void go() {
        if (movePredicate.isMovable()) {
            move();
        }
    }

    private void move() {
        this.position++;
    }

    public boolean hasPosition(int position) {
        return this.position == position;
    }

    public int getMaxPosition(int max) {
        return Math.max(position, max);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car)) {
            return false;
        }

        Car target = (Car) obj;
        return name.equals(target.name) && position == target.position;
    }
}
