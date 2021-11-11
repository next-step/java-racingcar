package racingcar;

import racingcar.domain.Racing;
import racingcar.view.InputView;

public class RacingGame {

    public static void main(String[] args) {
        int carCount = InputView.nextInt("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.nextInt("시도할 회수는 몇 회 인가요?");

        Racing racing = new Racing(carCount, tryCount);
        racing.start();
    }
}
