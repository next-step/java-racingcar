package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.movingcondition.MovingCondition;
import racingcar.domain.movingcondition.RandomMovingCondition;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
    private static final MovingCondition MOVING_CONDITION = new RandomMovingCondition();
    private final InputView inputView;
    private final ResultView resultView;

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int carCount = inputView.getCarCount();
        int playCount = inputView.getPlayCount();
        resultView.printTitle();

        List<Car> cars = generateCarList(carCount);
        play(cars, playCount);
    }

    private List<Car> generateCarList(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; ++i) {
            cars.add(new Car());
        }

        return cars;
    }

    private void play(List<Car> cars, int playCount) {
        RacingGame racingGame = new RacingGame(cars, MOVING_CONDITION, playCount);

        while (!racingGame.isGameEnd()) {
            List<Integer> roundResult = racingGame.play();
            resultView.printResult(roundResult);
        }
    }
}
