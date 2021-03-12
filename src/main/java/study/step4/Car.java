package study.step4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Car {

    private static final String CAR_NAME_LENGTH_OVER = "자동차의 이름은 5자를 초과할 수 없습니다.";
    private static final String DASH = "-";
    public static final String DELIMITER = "";
    private String carName;
    private int location;

    private Car(String carName) {
        this.carName = carName;
        this.location = 0;
    }

    public static Car of(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER);
        }

        return new Car(carName);
    }

    public Car move() {
        location++;
        return this;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }

    public String getLocationToString() {
        return Arrays.stream(new int[location])
                .mapToObj(i -> DASH)
                .collect(Collectors.joining(DELIMITER));
    }
}
