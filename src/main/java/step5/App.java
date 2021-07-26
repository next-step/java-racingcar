package step5;


import step5.game.Game;
import step5.game.GameDto;
import step5.move.BasicMoveStrategy;
import step5.view.InputView;
import step5.view.ResultView;

public class App {
    public static void main(String[] args) {
        GameDto gameDto = InputView.initGameEnv();

        Game game = gameDto.createGame();
        game.run(new BasicMoveStrategy());

        ResultView.of().showResult(game);
    }
}
