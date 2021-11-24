package step5.domain;

import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.dto.ResultOfCar;

import java.util.List;

public class CarRacingGame {

    private final CarRacingGameStrategy carRacingGameStrategy;
    private final List<Car> carList;
    private final int totalRound;
    private GameResult gameResult = new GameResult();

    public CarRacingGame(CarRacingGameStrategy carRacingGameStrategy, List<Car> carList, int totalRound) {
        this.carList = carList;
        this.carRacingGameStrategy = carRacingGameStrategy;
        this.totalRound = totalRound;
    }

    public void play() {
        for (int i = 0; i < totalRound; i++) {
            GameRound gameRound = new GameRound();
            gameRound.play(carList, carRacingGameStrategy);
            gameResult.add(gameRound);
        }
    }

    public List<GameRound> getGameResult() {
        return gameResult.totalResult();
    }

    public List<String> getWinner() {
        List<ResultOfCar> finalRoundResult = gameResult.finalResult();
        return Winners.decideWinner(finalRoundResult);
    }

}
