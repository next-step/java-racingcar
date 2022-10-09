package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingResult;
import racingcar.strategy.NumberGenerateStrategy;
import racingcar.strategy.RandomNumberGenerateStrategy;

public class Racing {

    private Racers racers;
    private final List<RacingResult> result = new ArrayList<>();

    private Racing() {
    }

    public Racing(final List<String> carNames) {
        this.racers = new Racers(carNames, new RandomNumberGenerateStrategy());
    }

    public Racing(final List<String> carNames, NumberGenerateStrategy strategy) {
        this.racers = new Racers(carNames, strategy);
    }

    public List<RacingResult> getResult() {
        return this.result;
    }

    public void race(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            racers.moveAll();
            result.add(RacingResult.from(racers));
        }
    }

    public List<String> winners() {
        int maxPosition = racers.maxPosition();
        return racers.getCars().stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
