package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Executor {

    public static void main(String[] args) {

        int numOfCar = InputView.getInput("자동차 대수는 몇 대 인가요?");
        int numOfTries = InputView.getInput("시도할 회수는 몇 회 인가요?");

        RacingGame racing = new RacingGame(numOfCar, numOfTries);

        List<MidScore> score = racing.racingGame();

        ResultView.printResultView(score);
    }
}
