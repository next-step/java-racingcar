package racingcar;

import racingcar.car.Cars;
import racingcar.random.DefaultRandomNumberGenerator;
import racingcar.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {
    private final InputView inputView;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingCar(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomNumberGenerator = new DefaultRandomNumberGenerator();
    }

    public void run() {
        int numberOfCars = inputView.getCarNumberFromUser();
        int numberOfRounds = inputView.getRoundNumberFromUser();

        Cars cars = new Cars(numberOfCars, randomNumberGenerator);

        startRacing(numberOfRounds, cars);
    }

    private void startRacing(int numberOfRounds, Cars cars) {
        for (int roundNumber = 1; roundNumber < numberOfRounds + 1; roundNumber++) {
            cars.moveCars();
            resultView.showRoundResult(roundNumber, cars);
        }
    }
}
