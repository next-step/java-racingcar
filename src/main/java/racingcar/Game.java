package racingcar;

import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.service.RacingGameService;
import racingcar.view.ResultView;

public class Game {
    public static void main(String[] args) {
        GameService<Cars> gameService = new RacingGameService();
        gameService.initGame();
        ResultView.printStart();
        while (gameService.isRunning()) {
            gameService.runStep();
            ResultView.printLocationView(gameService.getGameInstance());
        }
    }
}