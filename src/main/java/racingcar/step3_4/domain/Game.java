package racingcar.step3_4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final Random random = new Random();
    private static final int LIMIT = 10;
    private static final RandomValueGenerator randomValueGenerator = () -> random.nextInt(LIMIT);

    public GameRecord play(GameAttribute gameAttribute) {
        Names names = Names.of(gameAttribute.getCarNames());
        Cars cars = Cars.createCars(names);

        List<TryResult> tryResults = new ArrayList<>();
        for (int i = 0; i < gameAttribute.getTryCount(); i++) {
            cars.move(randomValueGenerator);

            tryResults.add(TryResult.of(cars.getCars()));
        }
        Winners winners = cars.determineWinners();

        return new GameRecord(List.copyOf(tryResults), winners);
    }
}
