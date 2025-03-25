package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.movepolicy.DefaultMoveStrategy;
import racingcar.movepolicy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.askCarNumbers();
        String carNamesInput = inputView.getCarNames();

        outputView.askRoundNumbers();
        int numberOfRounds = inputView.getNumberOfRounds();

        Cars cars = createCars(carNamesInput);
        Racing racing = new Racing(cars, numberOfRounds);

        racing.start();
        outputView.printRacingResult(racing.toString());
        outputView.showRace(racing.getWinners());
    }

    private Cars createCars(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        MoveStrategy moveStrategy = new DefaultMoveStrategy();

        List<Car> carList = Arrays.stream(carNames)
                .map(String::trim)
                .map(name -> new Car(name, moveStrategy))
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
