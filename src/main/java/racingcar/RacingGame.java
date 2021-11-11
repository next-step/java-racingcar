package racingcar;

import racingcar.domain.Racing;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;

import java.util.Random;

public class RacingGame {

    public static void main(String[] args) {

        String[] carNames = InputView
                .nextLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
                .split(",");

        MovingStrategy movingStrategy = new RandomMovingStrategy(new Random(System.currentTimeMillis()));

//        int carCount = InputView.nextInt("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.nextInt("시도할 회수는 몇 회 인가요?");

//        Racing racing = new Racing(carCount, tryCount, movingStrategy);
        Racing racing = new Racing(carNames, tryCount, movingStrategy);
        racing.start();
    }
}
