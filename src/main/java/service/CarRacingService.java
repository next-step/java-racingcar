package service;

import domain.Car;
import domain.CarRacingResultDto;
import domain.Cars;
import util.MoveStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRacingService {
    private static final String WRONG_INPUT_MESSAGE = "시도 회수는 1이상의 정수여야 합니다.";
    private static final String CORRECT_INPUT_PATTERN = "[0-9]*";
    private final MoveStrategy moveStrategy;

    public CarRacingService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarRacingResultDto registerCarsAndStartRacing(String carsName, String count) {
        Cars cars = new Cars(carsName);
        int attemptCount = validateAttemptCount(count);

        List<Map<String, Integer>> racingResults = startRacing(cars, attemptCount);
        List<Car> winners = cars.findWinners();

        return new CarRacingResultDto(winners, racingResults);
    }

    private List<Map<String, Integer>> startRacing(Cars cars, int attemptCount) {
        return Stream.generate(() -> cars.moveCars(moveStrategy))
                .limit(attemptCount)
                .collect(Collectors.toList());
    }

    private int validateAttemptCount(String count) {
        if (!count.matches(CORRECT_INPUT_PATTERN) || Integer.parseInt(count) < 1) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
        return Integer.parseInt(count);
    }
}
