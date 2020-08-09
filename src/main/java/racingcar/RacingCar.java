package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RacingCar extends RacingVehicle {
    private static final int FIRST_ATTEMPT = 0;

    public void race(int attemptNumber) {
        List<Integer> record = new ArrayList<>();

        Stream.iterate(0, attempt -> attempt + 1)
                .limit(attemptNumber)
                .forEach(attempt -> move(record, attempt));

        raceRecord = new RaceRecord(record);
    }

    private void move(List<Integer> record, int attempt) {
        int move = (attempt == FIRST_ATTEMPT)
                ? 0
                : record.get(attempt - 1);

        if (movable()) {
            move += 1;
        }

        record.add(move);
    }

}
