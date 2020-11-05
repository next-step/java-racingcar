package racingcar;

public class Car {
    private int position;
    private String name;
    private MoveStrategy strategy;

    public Car(Car car) {
        this.position = car.position;
        this.name = car.name;
        this.strategy = car.strategy;
    }

    public Car(String name, MoveStrategy strategy) {
        validateName(name);
        this.position = CarConst.START_POSITION;
        this.name = name;
        this.strategy = strategy;
    }

    public static boolean validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(CarConst.NULL_NAME_ERR);
        }
        if (name.length() > CarConst.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CarConst.MAX_NAME_LENGTH_EXCEEDED);
        }
        return true;
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

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
}
