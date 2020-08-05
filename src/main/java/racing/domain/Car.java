package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import static racing.domain.CarRacingProperty.MIN_CAR_NAME_LENGTH;
import static racing.domain.CarRacingProperty.MIN_MOVABLE_DISTANCE;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 %s자를 초과할 수 없습니다";
    private static final String INVALID_NAME_ERROR_MESSAGE = "Car name not allowed blank";
    private final String name;

    private int distance = 0;

    public Car(String name) {
        Verify.checkArgument(StringUtils.isNotBlank(name), INVALID_NAME_ERROR_MESSAGE);
        Verify.checkArgument(name.length() <= MIN_CAR_NAME_LENGTH,
            String.format(NAME_LENGTH_ERROR_MESSAGE, MIN_CAR_NAME_LENGTH));

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(int distance) {
        if (distance >= MIN_MOVABLE_DISTANCE) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

}
