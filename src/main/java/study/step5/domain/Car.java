package study.step5.domain;

public class Car {

    private static final int CAR_NAME_LENGTH_OVER = 5;
    private static final String CAR_NAME_LENGTH_ERROR = "자동차의 이름은 " +
            CAR_NAME_LENGTH_OVER  + "자를 초과할 수 없습니다.";

    private final String carName;
    private int location;

    private Car(final String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public static Car of(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_OVER) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }

        return new Car(carName);
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }

    public void move(int location) {
        this.location += location;
    }
}
