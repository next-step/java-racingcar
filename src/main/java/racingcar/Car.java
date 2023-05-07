package racingcar;

public class Car {

    private Position position;


    public Car(int moveCount) {
        this.position = new Position(moveCount);
    }


    public static Car create() {
        return new Car(0);
    }

    public void move(MoveStrategy random) {
        if (random.isMovable()) {
            this.position.increase();
        }
    }

    public int position() {
        return this.position.getMoveCount();
    }
}
