package racing.domain;

import racing.model.CarInfo;
import racing.util.NumberGenerator;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int RANDOM_NUMBER_BOUNDARY = 4;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private int position;
    private final String name;
    private final NumberGenerator numberGenerator;

    private Car(int position, String name, NumberGenerator numberGenerator) {
        this.position = position;
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public CarInfo getCarInfo() {
        return new CarInfo(this.position, this.name);
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= RANDOM_NUMBER_BOUNDARY;
    }

    public static Car create(String name, NumberGenerator numberGenerator) {
        validateCarName(name);
        return new Car(DEFAULT_POSITION, name, numberGenerator);
    }

    private static void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이상일 수 없습니다.");
        }
    }
}
