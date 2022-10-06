package racingcar.domain;

public class Car {
    private final CarMovePredicate movePredicate;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.movePredicate = new DefaultCarMovePredicate();
    }

    public Car(String name, CarMovePredicate movePredicate) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
