package racingcar;

import java.util.List;

public class Game {

    private final Cars cars;
    private final Round round;

    public Game(final String carNames, final int number) {
        this.cars = new Cars(carNames);
        this.round = new Round(number);
    }

    public GameResult play() {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < round.getNumber(); i++) {
            gameResult.addRoundResult(round());
        }
        gameResult.addWinner(winner());
        return gameResult;
    }

    private RaceResult round() {
        return new RaceResult(cars.race());
    }

    private List<CarResult> winner() {
        return cars.winner();
    }

}
