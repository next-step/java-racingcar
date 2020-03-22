package racingcar;

import racingcar.domain.Car;
import racingcar.domain.GameRole;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    private static final int ADVANCE_COUNT = 1;
    private static final String RESULT_PRINT = "실행 결과";

    public static void main(String[] args) {
        InputView view = new InputView();
        view.input();

        GameRole gameRole = new GameRole(ADVANCE_COUNT);
        RacingGame racingGame = new RacingGame(view.getTime(), Car.listOf(view.getCarNames()), gameRole);

        System.out.println(RESULT_PRINT);
        racingGame.start();

        ResultView.printWinner(racingGame.findWinner());
    }
}
