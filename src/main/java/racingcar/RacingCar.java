package racingcar;

import exception.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RacingCar extends RacingVehicle {
    private static final int FIRST_ATTEMPT = 0;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void race(int attemptNumber, CarMover carMover) {
        List<Integer> record = new ArrayList<>();

        Stream.iterate(0, attempt -> attempt + 1)
                .limit(attemptNumber)
                .forEach(attempt -> move(record, attempt, carMover));

        raceRecord = new RaceRecord(name, record);
    }

    private void move(List<Integer> record, int attempt, CarMover carMover) {
        int move = (attempt == FIRST_ATTEMPT)
                ? 0
                : record.get(attempt - 1);

        if (carMover.movable()) {
            move += 1;
        }

        record.add(move);
    }

    public static void checkNameValidation(RacingCar racingCar) {
        if (racingCar.getName().length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.RACING_CAR_NAME_IS_TOO_SHORT);
        }

        if (racingCar.getName().length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.RACING_CAR_NAME_IS_TOO_LONG);
        }
    }
}
