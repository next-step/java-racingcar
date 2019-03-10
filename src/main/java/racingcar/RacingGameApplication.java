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

        racingGame.start(parameter.getTryCount());

        List<Car> cars = racingGame.getCars();
        List<Car> winners = racingGameJudge.getWinners(cars);
        RacingGameOutputView.printWinners(winners);
    }
}