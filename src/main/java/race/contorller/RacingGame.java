package race.contorller;

import race.domain.Cars;
import race.view.InputView;
import race.view.ResultView;
import utils.number.NumberGenerator;
import utils.number.RandomNumberGenerator;

public class RacingGame {


    public static void run() {
        String[] carNames = InputView.requestCarNames();
        int countOfTrial = InputView.requestCountOfTrial();

        ResultView.start();
        Cars cars = Cars.createInstance(carNames);

        NumberGenerator randomGenerator = new RandomNumberGenerator();
        racing(cars, randomGenerator, countOfTrial);


        ResultView.showWinners(cars.chooseWinners());
    }

    private static void racing(Cars cars, NumberGenerator numberGenerator, int countOfTrial) {
        while (countOfTrial > 0) {
            cars.moveCars(numberGenerator);
            ResultView.showProcess(cars);
            countOfTrial--;
        }
    }
}
