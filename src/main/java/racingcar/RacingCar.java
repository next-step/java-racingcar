package racingcar;

import racingcar.car.CarController;
import racingcar.random.DefaultRandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCar {
    private final InputView inputView;
    private final ResultView resultView;
    private final Round round;

    public RacingCar(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.round = new Round(new CarController(new DefaultRandomNumberGenerator()));
    }

    public void run() {
        int numberOfCars = inputView.getCarNumberFromUser();
        int numberOfRounds = inputView.getRoundNumberFromUser();

        round.init(numberOfCars);
        startRacing(numberOfRounds);

    }

    private void startRacing(int totalRound) {
        for (int roundCount = 1; roundCount < totalRound + 1; roundCount++) {
            round.start();
            resultView.showRoundResult(roundCount, round.getCars());
        }
    }

}
