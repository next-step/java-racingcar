package step3;

import step3.strategy.MoveStrategy;
import step3.strategy.PrintMarkStrategy;
import step3.game.RacingGameImpl;
import step3.game.RacingInfomation;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        RacingGameImpl game = new RacingGameImpl();
        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();
        RacingInfomation racingInfomation = inputView.execute();
        game.execute(racingInfomation, MoveStrategy.defaultStrategy(new Random()));
        resultView.viewAll(game.getResultAll(), new PrintMarkStrategy("-"));

    }
}
