package study.step3.domain;

import study.step3.view.InputView;
import study.step3.view.OutputView;

import java.util.List;

public class CarRacing {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.play();
    }

    public void play() {
        String[] carNames = inputView.inputCarNames();
        int countOfMove = inputView.inputCountOfMove();

        Cars cars = new Cars(carNames,
                new LessThanMoveCondition(4, new RandomMove()));

        outputView.outputTextOfResult();
        for (int i = 0; i < countOfMove; i++) {
            cars.moveForward();
            outputView.outputPositionOfCarsWithName(cars.toCarNames(), cars.toPositionOfCars());
        }

        List<String> winners = cars.findWinner();
        outputView.outputWinners(winners);
    }
}
