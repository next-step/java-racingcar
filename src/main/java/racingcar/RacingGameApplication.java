package racingcar;

import racingcar.ui.RacingGameOutputView;
import racingcar.ui.RacingGameParameterInputView;
import racingcar.vo.RacingGameParameter;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameApplication.start();
    }

    public static void start() {
        RacingGameParameter parameter = RacingGameParameterInputView.readRacingGameParameter();

        RacingGame racingGame = new RacingGame(parameter.getCarNames());
        RacingGameJudge racingGameJudge = new RacingGameJudge();

        RacingGameOutputView.printLine("실행 결과");
        RacingGameOutputView.printEmptyLine();

        startRacingGame(racingGame, parameter.getTryCount());

        List<Car> cars = racingGame.getCars();
        List<Car> winners = racingGameJudge.getWinners(cars);
        RacingGameOutputView.printWinners(winners);
    }

    private static void startRacingGame(RacingGame racingGame, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingGame.runCars();

            List<Car> cars = racingGame.getCars();
            RacingGameOutputView.printMovedDistanceOfCars(cars);
            RacingGameOutputView.printEmptyLine();
        }
    }
}