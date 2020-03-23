package racingcar.domain;

public class Car {
    public static final int START_POSITION = 0;

    private String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    Car(Car car) {
        this.position = car.getPosition();
        this.name = car.getName();
    }

    Car(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    Car move(boolean moveCondition) {
        if (moveCondition) {
            position++;
        }
        return new Car(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car car) {
        return getPosition() == car.getPosition();
    }
}
