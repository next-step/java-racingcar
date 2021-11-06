package racingcar.controller.convert;

import racingcar.controller.dto.RaceResult;
import racingcar.controller.dto.RacingCarOutput;
import racingcar.service.domain.Record;
import racingcar.service.dto.RoundResult;
import racingcar.service.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarOutputConverter {
    private RacingCarOutputConverter() {
    }

    public static RacingCarOutput convert(RoundResult roundResult) {
        return RacingCarOutput.of(roundResult.getFinalWinnerName(), convertToRaceResultList(roundResult.getRecords()));
    }

    private static List<RaceResult> convertToRaceResultList(List<Record> records) {
        return records.stream()
                .map(RacingCarOutputConverter::convertToRaceResult)
                .collect(Collectors.toList());
    }

    private static RaceResult convertToRaceResult(Record record) {
        return RaceResult.of(record.getCurrentRound(), convertToRace(record.getCars()));
    }

    private static List<RaceResult.Race> convertToRace(Cars cars) {
        return cars.getCarList().stream()
                .map(car -> RaceResult.Race.of(car.getName(), car.currentPosition()))
                .collect(Collectors.toList());
    }
}
