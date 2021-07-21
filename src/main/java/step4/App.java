package step4;


import step4.game.Game;
import step4.game.GameDto;
import step4.view.InputView;
import step4.view.ResultView;

public class App {
    public static void main(String[] args) {
        GameDto gameDto = InputView.initGameEnv();

        Game game = gameDto.createGame();
        game.run();

        ResultView.showResult(game);
    }
}
