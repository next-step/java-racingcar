package racingcar;

import racingcar.number_generator.NumberGenerator;
import racingcar.number_generator.RandomNumberGenerator;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    static final String OVER_MAX_NAME_SIZE_ERROR_STRING = "이름의 길이가 " + MAX_NAME_SIZE + "글자 초과입니다.";
    private static final int FORWARD_THRESHOLD = 4;
    
    private final String name;
    private final NumberGenerator numberGenerator;
    private int distance;

    Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public Car(String name) {
        this(name, new RandomNumberGenerator());
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(OVER_MAX_NAME_SIZE_ERROR_STRING);
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    void forward() {
        distance++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public void progress() {
        if (canMove()) {
            forward();
        }
    }

    private boolean canMove() {
        return numberGenerator.generate() >= FORWARD_THRESHOLD;
    }
}
