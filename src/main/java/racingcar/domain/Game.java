package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Cars cars;
    private final int gameRounds;

    public Game(String carsNames, int gameRounds) {
        this(new Cars(carsNames), gameRounds);
    }

    // 주생성자
    public Game(Cars cars, int gameRounds) {
        this.cars = cars;
        this.gameRounds = gameRounds;
    }

    public GameResults play() {
        List<RoundResult> gameResults = new ArrayList<>();
        for (int i = 0; i < gameRounds; i++) {
            cars.moveCarsByStrategy(new RandomMoveStrategy());
            gameResults.add(saveRoundResult());
        }
        return new GameResults(gameResults);
    }

    private RoundResult saveRoundResult() {
        return new RoundResult(cars.showCarsPositions());
    }
}
