package racingcar;

import racingcar.game.RacingGameImpl;
import racingcar.game.RacingInfomation;
import racingcar.strategy.CarNameInputStrategy;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.PrintMarkStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        RacingGameImpl game = new RacingGameImpl();
        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();
        RacingInfomation racingInfomation = inputView.execute(new CarNameInputStrategy());
        game.execute(racingInfomation, MoveStrategy.defaultStrategy(new Random()));
        resultView.viewAll(game.getGameHistory(), new PrintMarkStrategy("-"));

    }
}
