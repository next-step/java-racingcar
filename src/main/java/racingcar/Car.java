package racingcar;

public class Car {
    private int position;
    private MoveStrategy strategy;

    public Car(MoveStrategy strategy) {
        this.position = NumConst.START_POSITION;
        this.strategy = strategy;
    }

    public void move() {
        if (this.strategy.checkMovable()) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }
}
