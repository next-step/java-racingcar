package RacingCar;

import RacingCar.domain.Cars;
import RacingCar.service.GameService;
import RacingCar.service.RacingGameService;
import RacingCar.view.ResultView;

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