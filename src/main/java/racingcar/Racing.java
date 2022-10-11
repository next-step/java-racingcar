package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.output.RacingResult;
import racingcar.strategy.NumberGenerateStrategy;

public class Racing {

    private Racers racers;
    private final List<RacingResult> result = new ArrayList<>();

    private Racing() {
    }

    public Racing(final List<String> carNames) {
        this.racers = new Racers(carNames);
    }

    public Racing(final List<String> carNames, final NumberGenerateStrategy strategy) {
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
        int maxPosition = racers.getMaxPosition();
        return racers.findSamePositionCars(maxPosition);
    }
}
