package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RoundResult;
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
        List<String> carNames = inputView.getCarNames();
        int playCount = inputView.getPlayCount();
        resultView.printTitle();

        List<Car> cars = generateCarList(carNames);
        play(cars, playCount);
    }

    private List<Car> generateCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void play(List<Car> cars, int playCount) {
        RacingGame racingGame = new RacingGame(new Cars(cars), MOVING_CONDITION, playCount);

        while (!racingGame.isGameEnd()) {
            RoundResult roundResult = racingGame.play();
            resultView.printResult(roundResult);
        }

        resultView.printWinners(racingGame.findWinners());
    }
}
