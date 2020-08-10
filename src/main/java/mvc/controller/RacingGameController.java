package mvc.controller;


import mvc.domain.game.RacingGame;
import mvc.domain.dto.GameInputs;
import mvc.domain.dto.GameResults;
import mvc.view.ViewResolver;


public class RacingGameController {
    private final ViewResolver viewResolver;
    private final RacingGame racingGame;

    private RacingGameController() {
        this.viewResolver = ViewResolver.createViewResolver();

        GameInputs gameInputs = viewResolver.getGameInputs();
        this.racingGame = RacingGame.createGame(gameInputs);
    }

    public void start() {
        GameResults results = this.racingGame.startGame();

        this.viewResolver.printGameResult(results);
    }

    public static RacingGameController createGameController() {
        return new RacingGameController();
    }
}
