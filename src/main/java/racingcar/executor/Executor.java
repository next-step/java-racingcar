package racingcar.executor;

import racingcar.RacingGame;
import racingcar.view.InputView;

public class Executor {

    public static void main(String[] args) {

        String carNameString = InputView.getInput("경주할 자동차 이름을 입력하세요");
        int numOfTries = InputView.getNumberInput("시도할 회수는 몇 회 인가요?");

        RacingGame racing = new RacingGame(carNameString, numOfTries);
        racing.racingGame();
    }
}
