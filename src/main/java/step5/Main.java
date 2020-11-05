package step5;

import step5.controller.game.RacingGame;
import step5.controller.game.RacingGameImpl;
import step5.domain.dto.RacingInfomation;
import step5.strategy.MoveStrategy;
import step5.strategy.PrintMarkStrategy;
import step5.strategy.RacingInfoInputStrategy;
import step5.view.InputView;
import step5.view.RacingResultView;
import step5.view.ResultView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        RacingGame game = new RacingGameImpl();
        InputView inputView = InputView.getInstance();
        ResultView resultView = RacingResultView.getInstance();
        Random random = new Random();

        RacingInfomation racingInfomation = inputView.execute(new RacingInfoInputStrategy());

        game.play(racingInfomation, MoveStrategy.defaultStrategy(random));

        resultView.render(game.getGameHistory(), new PrintMarkStrategy("-"));
    }
}
