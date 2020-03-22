package racingcar;

import racingcar.controller.RacingCar;
import racingcar.model.Cars;
import racingcar.model.Results;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

        Question question = new Question(inputView);
        question.generateForCarCount();
        question.generateForTryCount();

        RacingCar racingCar = new RacingCar(inputView, randomNumGenerator);
        Cars cars = racingCar.ready();
        Results results = racingCar.start();
        Winners winners = racingCar.findWinners();

        OutputView.printGame(cars, results);
        OutputView.printWinners(winners);

    }
}