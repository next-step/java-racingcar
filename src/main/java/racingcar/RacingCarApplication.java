package racingcar;

import racingcar.moving.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {

    private static final String NUM_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String LOOP_COUNT = "시도할 횟수는 몇 회 인가요?";

    public static void main(String[] args) {
        int numOfCar = InputView.input(NUM_OF_CAR_MESSAGE);
        int loopCount = InputView.input(LOOP_COUNT);

        Racing racing = Racing.of(numOfCar, new RandomMovingStrategy());
        ResultView.printResultMessage();
        for (int i = 0; i < loopCount; i++) {
            List<Car> cars = racing.run();
            ResultView.printResult(cars);
        }
    }
}
