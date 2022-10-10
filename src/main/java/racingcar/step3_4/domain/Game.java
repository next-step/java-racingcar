package racingcar.step3_4.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.step3_4.strategy.ValueGenerator;

public class Game {

    private final ValueGenerator valueGenerator;

    public Game(ValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    public GameRecord play(GameAttribute gameAttribute) {
        Names names = Names.of(gameAttribute.getCarNames());
        Cars cars = Cars.createCars(names);

        List<TryResult> tryResults = new ArrayList<>();
        for (int i = 0; i < gameAttribute.getTryCount(); i++) {
            cars.move(valueGenerator);

            tryResults.add(TryResult.of(cars.getCars()));
        }
        Winners winners = cars.determineWinners();

        return new GameRecord(List.copyOf(tryResults), winners);
    }
}
