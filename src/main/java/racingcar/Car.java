package racingcar;

public class Car {
    private int position;
    private String name;
    private MoveStrategy strategy;

    public Car(String name, MoveStrategy strategy) {
        if (name == null) {
            throw new IllegalArgumentException(CarConst.NULL_NAME_ERR);
        }
        if (name.length() > CarConst.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CarConst.MAX_NAME_LENGTH_EXCEEDED);
        }

        this.position = CarConst.START_POSITION;
        this.name = name;
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

    public String getName() {
        return this.name;
    }
}
