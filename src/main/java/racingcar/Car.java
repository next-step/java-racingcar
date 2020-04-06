package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int NUMBER_GENERATE_RANGE = 10;

    private final int position;
    private final String name;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        validate(name, position);
        this.name = name;
        this.position = position;
    }

//    public Car changeCarPosition(Car car, int randomNumber) {
//        MovingStrategy movingStrategy = new MovingStrategy();
//        if (movingStrategy.movable(getRandomNumber())) {
//            return new Car(this.name, this.position + 1);
//        }
//        return new Car(this.name, car.position);
//    }

    public Car move() {
        MovingStrategy movingStrategy = new MovingStrategy();
        if (movingStrategy.movable(getRandomNumber())) {
            return new Car(this.name, this.position + 1);
        }
        return new Car(this.name, this.position);
    }

    public int getPosition() {
        return position;
    }

    public void addWhenWinner(List<Car> winners, int maxPosition) {
        if (match(maxPosition)) {
            winners.add(this);
        }
    }

    public int getMaxPosition(int maxPosition) {
        if (maxPosition < this.position) {
            return this.position;
        }
        return maxPosition;
    }

    private boolean match(int maxPosition) {
        return this.position == maxPosition;
    }

    private void validate(String name, int position) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }

        if (position < 0) {
            throw new IllegalArgumentException("위치 값이 0보다 작을 수 없습니다.");
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(NUMBER_GENERATE_RANGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }

    public String getName() {
        return name;
    }
}
