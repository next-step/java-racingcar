package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RandomValueDriveWay;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        final String carNames = InputView.inputCarNames();
        final int tryCount = InputView.inputTryCount();

        Racing racing = new Racing(carNames, tryCount, new RandomValueDriveWay());

        System.out.println("\n실행 결과");
        while (!racing.isFinish()) {
            racing.race();
            ResultView.printCars(racing.getCars());
        }

        ResultView.printWinners(racing.findWinners());
    }
}
