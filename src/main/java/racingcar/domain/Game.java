package racingcar.domain;

import java.util.List;

public class Game {

    private final Cars cars;
    private final Round round;

    public Game(final String carNames, final int number, final MoveStrategy moveStrategy) {
        this.cars = Cars.readyCars(carNames, moveStrategy);
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

    private RoundResult round() {
        return new RoundResult(cars.race());
    }

    private List<CarResult> winner() {
        return cars.winners();
    }

}
