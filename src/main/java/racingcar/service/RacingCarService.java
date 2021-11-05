package racingcar.service;

import racingcar.service.domain.Car;
import racingcar.service.domain.factory.CarFactory;
import racingcar.service.dto.Record;
import racingcar.service.dto.RoundReady;
import racingcar.service.dto.RoundResult;
import racingcar.service.strategy.RoundRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private static final int START_ROUND = 1;

    private final RoundRule roundRule;
    private final List<Car> cars;
    private final Integer totalRoundCount;

    private RacingCarService(RoundReady readyDTO) {
        roundRule = readyDTO.getRoundRule();
        cars = CarFactory.createCar(readyDTO.getCarNames());
        totalRoundCount = readyDTO.getTotalRoundCount();
    }

    public static RacingCarService ready(RoundReady initValue) {
        return new RacingCarService(initValue);
    }

    public RoundResult startRound() {
        List<Record> records = new ArrayList<>();
        for (int round = START_ROUND; round <= totalRoundCount; round++) {
            race();
            records.add(recordRace(round));
        }
        return RoundResult.of(records);
    }

    private void race() {
        cars.forEach(car -> car.race(roundRule));
    }

    private Record recordRace(int round) {
        return Record.of(round, recordCar());
    }

    private List<Car> recordCar() {
        return cars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());
    }
}
