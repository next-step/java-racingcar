package racingcar;

public class Car {
    private final CarMovePredicate movePredicate;
    private int position = 0;

    public Car() {
        this.movePredicate = new DefaultCarMovePredicate();
    }

    public Car(CarMovePredicate movePredicate) {
        this.movePredicate = movePredicate;
    }

    public int getPosition() {
        return position;
    }

    public void print() {
        ResultView.printCarPosition(position);
    }

    public void go() {
        if (movePredicate.test()) {
            move();
        }
    }

    private void move() {
        this.position++;
    }
}
