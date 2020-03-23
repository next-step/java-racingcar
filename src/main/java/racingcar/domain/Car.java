package racingcar.domain;

public class Car {
    public static final int START_POSITION = 0;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    Car(Car car) {
        this.position = car.getPosition();
    }

    Car(Integer position) {
        this.position = position;
    }

    Car move(boolean moveCondition) {
        if (moveCondition) {
            position++;
        }
        return new Car(position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                '}';
    }
}
