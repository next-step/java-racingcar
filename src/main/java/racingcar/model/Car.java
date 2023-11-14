package racingcar.model;

public class Car {

    private static final int MINIMUM_SUCCESS_VALUE = 4;
    private static final int RANDOM_RANGE = 9;
    private final String name;
    private Position position;


    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = new Position(0);
    }

    public Car(String name, Position position) {
        this(name);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isMaxPosition(Car car) {
        return this.position.compareTo(car.position) > 0;
    }

    public Car getMaxPositionCar(Car car)
    {
        if(isMaxPosition(car))
            return car;
        return this;
    }

    public int getRandomRange() {
        return RANDOM_RANGE;
    }

    public void move(int number) {
        if (number >= MINIMUM_SUCCESS_VALUE) {
            position.increase();
        }
    }
}
