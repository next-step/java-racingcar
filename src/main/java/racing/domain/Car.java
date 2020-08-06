package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

import static racing.domain.CarRacingMessage.INVALID_NAME_ERROR_MESSAGE;
import static racing.domain.CarRacingMessage.NAME_LENGTH_ERROR_MESSAGE;
import static racing.domain.CarRacingProperty.MIN_CAR_NAME_LENGTH;
import static racing.domain.CarRacingProperty.MIN_MOVABLE_NUMBER;

public class Car {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        Verify.checkArgument(StringUtils.isNotBlank(name), INVALID_NAME_ERROR_MESSAGE);
        Verify.checkArgument(name.length() <= MIN_CAR_NAME_LENGTH,
            MessageFormat.format(NAME_LENGTH_ERROR_MESSAGE, MIN_CAR_NAME_LENGTH));

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_NUMBER) {
            distance++;
        }
        return distance;
    }

    public int getDistance() {
        return distance;
    }

}
