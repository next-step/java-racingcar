package service;

import domain.AttemptCount;
import domain.CarRacingResultDto;
import domain.Cars;
import domain.dto.RacingResult;
import domain.dto.RacingResults;
import domain.dto.WinnerResult;
import util.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacingService {
    private final MoveStrategy moveStrategy;

    public CarRacingService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarRacingResultDto registerCarsAndStartRacing(String carsName, String count) {
        Cars cars = new Cars(carsName);
        AttemptCount attemptCount = new AttemptCount(count);

        List<RacingResults> racingResultTotal = startRacing(cars, attemptCount);
        List<WinnerResult> winners = findWinnersAndConvertDto(cars);

        return new CarRacingResultDto(winners, racingResultTotal);
    }

    private List<WinnerResult> findWinnersAndConvertDto(Cars cars) {
        return cars.findWinners().stream()
                .map(WinnerResult::from)
                .collect(Collectors.toList());
    }

    private List<RacingResults> startRacing(Cars cars, AttemptCount attemptCount) {
        return Stream.generate(() -> cars.moveCars(moveStrategy).stream()
                .map(RacingResult::from)
                .collect(Collectors.toList()))
                .limit(attemptCount.getAttemptCount())
                .map(RacingResults::from)
                .collect(Collectors.toList());
    }
}
