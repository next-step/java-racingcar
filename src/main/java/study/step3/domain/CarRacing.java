package study.step3.domain;

import study.step3.view.InputView;
import study.step3.view.OutputView;

public class CarRacing {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        carRacing.play();
    }

    public void play() {
        int countOfCar = inputView.inputCountOfCar();
        int countOfMove = inputView.inputCountOfMove();

        Cars cars = new Cars(countOfCar);

        outputView.outputTextOfResult();
        for (int i = 0; i < countOfMove; i++) {
            cars.moveForward();
            outputView.outputPositionOfCar(cars.toPositionOfCars());
        }
    }
}
