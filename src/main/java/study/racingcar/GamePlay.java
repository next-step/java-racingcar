package study.racingcar;

import java.util.List;

import study.racingcar.domain.Cars;
import study.racingcar.domain.Name;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.strategy.MoveStrategy;
import study.racingcar.domain.strategy.RandomNumberStrategy;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class GamePlay {
    public static void main(String[] args) {
        playGame(new RandomNumberStrategy());
    }

    public static void playGame(MoveStrategy moveStrategy) {

        RacingGame game = initGame();

        printStart();

        while (!game.isEnd()) {
            Cars cars = game.race(moveStrategy);
            ResultView.printCurrentRacingResult(cars);
        }

        findGameWinners(game);

    }

    private static RacingGame initGame() {
        List<Name> names = InputView.inputCarNames();
        int tryNo = InputView.inputTryNo();

        return new RacingGame(names, tryNo);
    }

    private static void findGameWinners(RacingGame game) {
        List<Name> winners = game.findWinners();
        ResultView.printWinner(winners);
    }

    private static void printStart() {
        ResultView.printStart();
    }


}
