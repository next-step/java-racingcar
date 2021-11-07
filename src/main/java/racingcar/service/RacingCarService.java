package racingcar.service;

import racingcar.service.domain.Car;
import racingcar.service.domain.Record;
import racingcar.service.domain.factory.CarFactory;
import racingcar.service.domain.factory.RecordFactory;
import racingcar.service.dto.RoundReady;
import racingcar.service.dto.RoundResult;
import racingcar.service.strategy.RoundRule;
import racingcar.service.value.Round;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private static final int START_ROUND_COUNT = 1;

    private final RoundRule roundRule;
    private final Round finalRound;
    private final List<Car> cars;

    private RacingCarService(RoundReady roundReady) {
        roundRule = roundReady.getRoundRule();
        finalRound = roundReady.getFinalRound();
        cars = CarFactory.create(roundReady.getCarNames());
    }

    public static RacingCarService ready(RoundReady roundReady) {
        return new RacingCarService(roundReady);
    }

    public RoundResult startRound() {
        List<Record> recordList = new ArrayList<>();
        for (int round = START_ROUND_COUNT; round <= finalRound.getRound(); round++) {
            startRace();
            recordList.add(recordRace(round));
        }
        return RoundResult.of(recordList);
    }

    private void startRace() {
        cars.forEach(car -> car.startRace(roundRule));
    }

    private Record recordRace(Integer round) {
        return RecordFactory.create(round, cars);
    }
}
