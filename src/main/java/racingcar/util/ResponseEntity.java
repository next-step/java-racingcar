package racingcar.util;

import racingcar.dto.output.RacingGameResponse;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.dto.output.RacingGameRecord;
import racingcar.dto.output.RacingGameResult;

import java.util.ArrayList;
import java.util.List;

public class ResponseEntity {

    private ResponseEntity() {
    }

    public static RacingGameResponse ok(List<Cars> racingGameResult, List<String> winners) {
        List<RacingGameRecord> racingGameRecords = new ArrayList<>();

        for (Cars cars : racingGameResult) {
            racingGameRecords.add(getRacingGameResult(cars));
        }

        return new RacingGameResponse(racingGameRecords, winners);
    }

    private static RacingGameRecord getRacingGameResult(Cars cars) {
        List<RacingGameResult> racingGameResults = new ArrayList<>();
        for (Car car : cars.getValue()) {
            racingGameResults.add(new RacingGameResult(car.getName(), car.getPosition()));
        }
        return new RacingGameRecord(racingGameResults);
    }

}
