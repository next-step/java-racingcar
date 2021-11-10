package step4;

import step4.service.Game;
import step4.service.dto.GameInformation;
import step4.strategy.MoveStrategy;
import step4.strategy.NumberGenerator;
import step4.strategy.RandomMoveStrategy;
import step4.strategy.RandomNumberGenerator;
import step4.view.InputView;
import step4.view.ResultView;

public class main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameInformation gameInformation = inputView.input();

        int move_condition = 4;
        NumberGenerator numberGenerator = new RandomNumberGenerator(10);

        MoveStrategy moveStrategy = new RandomMoveStrategy(move_condition, numberGenerator);

        Game game = Game.of(gameInformation, moveStrategy);
        game.start();

        ResultView resultView = ResultView.from(game.getGameHistory(), gameInformation);
        resultView.view();
    }
}
