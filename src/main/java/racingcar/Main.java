package racingcar;

import racingcar.game.RacingGameImpl;
import racingcar.game.RacingInfomation;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.PrintMarkStrategy;
import racingcar.strategy.RacingInfoInputStrategy;
import racingcar.util.UtilContainer;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        RacingGameImpl game = new RacingGameImpl();
        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();


        RacingInfomation racingInfomation = inputView.execute(new RacingInfoInputStrategy());

        game.execute(racingInfomation, MoveStrategy.defaultStrategy(UtilContainer.getRandom()));

        resultView.viewAll(game.getGameHistory(), new PrintMarkStrategy("-"));
    }
}
