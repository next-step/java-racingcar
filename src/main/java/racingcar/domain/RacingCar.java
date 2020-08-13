package racingcar.domain;

import exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RacingCar extends RacingVehicle {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    private RacingCar(String name) {
        this.name = name;
    }

    public static RacingCar of(String name) {
        checkNameValidation(name);

        return new RacingCar(name);
    }

    public void race(int attemptNumber, CarMover carMover) {
        List<Boolean> record = new ArrayList<>();

        Stream.iterate(0, attempt -> attempt + 1)
                .limit(attemptNumber)
                .forEach(attempt -> move(record, carMover));

        raceRecord = new RaceRecord(name, record);
    }

    private void move(List<Boolean> record, CarMover carMover) {
        record.add(carMover.movable());
    }

    public static void checkNameValidation(String name) {
        if (name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.RACING_CAR_NAME_IS_TOO_SHORT);
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.RACING_CAR_NAME_IS_TOO_LONG);
        }
    }
}
