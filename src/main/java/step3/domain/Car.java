package step3.domain;

public class Car {

    private static final String DELIMITER = "-";
    private Position position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = new Position(position);
    }

    public void move() {
        if (isMove()) {
            position = position.increase();
        }
    }

    private boolean isMove() {
        return new RandomMoveStrategy().isMove();
    }

    public int position() {
        return position.position();
    }

    @Override
    public String toString() {
        return DELIMITER.repeat(position());
    }
}
