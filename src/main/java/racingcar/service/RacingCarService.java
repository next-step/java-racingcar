package racingcar.service;

import racingcar.service.domain.Car;
import racingcar.service.domain.factory.CarFactory;
import racingcar.service.dto.RoundReady;
import racingcar.service.dto.RoundResult;
import racingcar.service.model.Record;
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
        List<Record> records = new ArrayList<>();
        for (int round = START_ROUND_COUNT; round <= finalRound.getRound(); round++) {
            race();
            records.add(recordRace(Round.from(round)));
        }
        return RoundResult.of(records);
    }

    private void race() {
        cars.forEach(car -> car.race(roundRule));
    }

    private Record recordRace(Round round) {
        return Record.of(round, cars);
    }
}
