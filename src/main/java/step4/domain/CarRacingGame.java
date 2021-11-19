package step4.domain;

import step4.domain.cargameStrategy.CarRacingGameStrategy;
import step4.exception.RacingGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRacingGame {

    private final CarRacingGameStrategy carRacingGameStrategy;
    private List<GameRound> gameResult;
    private List<Car> carList;
    private final int totalRound;

    CarRacingGame(CarRacingGameStrategy carRacingGameStrategy, List<Car> carList, int totalRound) {
        this.carList = carList;
        this.carRacingGameStrategy = carRacingGameStrategy;
        this.totalRound = totalRound;
    }

    void play() {
        gameResult = new ArrayList<>();
        for (int i = 0; i < totalRound; i++) {
            GameRound gameRound = new GameRound();
            gameRound.play(carList, carRacingGameStrategy);
            gameResult.add(gameRound);
        }
    }


    public List<GameRound> getGameResult() {
        if (gameResult == null) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다");
        }
        return Collections.unmodifiableList(gameResult);
    }

    public List<String> getWinner() {
        if (gameResult == null || gameResult.isEmpty()) {
            throw new RacingGameException("아직 게임을 진행하지 않았습니다");
        }
        GameRound finalRound = gameResult.get(totalRound - 1);
        List<String> winningCarNames = finalRound.getWinners();
        return Collections.unmodifiableList(winningCarNames);

    }
}
