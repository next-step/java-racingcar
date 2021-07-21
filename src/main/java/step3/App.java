package step3;

import step3.game.Game;
import step3.game.GameDto;
import step3.view.InputView;
import step3.view.ResultView;

public class App {
    public static void main(String[] args) {
        GameDto gameDto = InputView.initGameEnv();

        Game game = gameDto.createGame();
        game.run();

        ResultView.showResult(game);
    }
}
