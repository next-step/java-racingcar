package racingcar;

public class Car {
    private int position;
    private String name;
    private MoveStrategy strategy;

    private Car(int position, String name, MoveStrategy strategy) {
        this.position = position;
        this.name = name;
        this.strategy = strategy;
    }

    public static Car createCar(String name, MoveStrategy strategy) {
        validateName(name);
        int position = CarConst.START_POSITION;
        return new Car(position, name, strategy);
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

    @Override
    public Car clone() {
        return new Car(position, name, strategy);
    }

    public void move() {
        if (strategy.checkMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }
}
