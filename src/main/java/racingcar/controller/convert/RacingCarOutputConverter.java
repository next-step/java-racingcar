package racingcar.controller.convert;

import racingcar.controller.dto.RaceResult;
import racingcar.controller.dto.RacingCarOutput;
import racingcar.service.domain.Car;
import racingcar.service.dto.RoundResult;
import racingcar.service.domain.Record;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarOutputConverter {
    private RacingCarOutputConverter() {
    }

    public static RacingCarOutput convert(RoundResult roundResult) {
        return RacingCarOutput.of(roundResult.getFinalWinnerName(), convertRaceResultList(roundResult.getRecords()));
    }

    private static List<RaceResult> convertRaceResultList(List<Record> records) {
        return records.stream()
                .map(RacingCarOutputConverter::convertToRaceResult)
                .collect(Collectors.toList());
    }

    private static RaceResult convertToRaceResult(Record record) {
        return RaceResult.of(record.getCurrentRound(), convertToRace(record.getCarList()));
    }

    private static List<RaceResult.Race> convertToRace(List<Car> carList) {
        return carList.stream()
                .map(car -> RaceResult.Race.of(car.getName(), car.currentPosition()))
                .collect(Collectors.toList());
    }
}
