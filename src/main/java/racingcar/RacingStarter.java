package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RandomMovingStrategy;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingStarter {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String[] requestedCarNames = inputView.requestCarNames();
        int requestedMoveNums = inputView.requestMoveNums();

        List<Car> cars = Racing.create(requestedCarNames);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(randomNumberGenerator);
        Racing racing = new Racing(requestedCarNames, cars, randomMovingStrategy);

        for (int i = 0; i < requestedMoveNums; i++) {
            racing.race();
            resultView.openResults(racing);
        }

        resultView.noticeWinner(racing.findWinner());
    }
}