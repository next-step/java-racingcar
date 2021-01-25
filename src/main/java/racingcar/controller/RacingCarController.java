package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.domain.Car;
import racingcar.util.PrintUtils;
import racingcar.view.RacingCarView;

public class RacingCarController {

    RacingCarView racingCarView = new RacingCarView();

    public Game initializeGameInfo() {
        String[] cars = racingCarView.inputCarNames();
        List<Car> carInfos = racingCarView.createCars(cars);
        int gameCnt = racingCarView.inputGameTryCnt();
        return new Game(gameCnt, carInfos);
    }

    public void start(Game game) {
        game.play();
        PrintUtils.printWinner(game.getWinner());
    }
}
