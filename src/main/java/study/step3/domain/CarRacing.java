package study.step3.domain;

import study.step3.domain.Car;
import study.step3.view.InputView;
import study.step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacing {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private MoveStrategy moveStrategy;
    private final List<Car> cars = new ArrayList<>();

    public CarRacing(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        int countOfCar = inputView.inputCountOfCar();
        int countOfMove = inputView.inputCountOfMove();

        for (int i = 0; i < countOfCar; i++) {
            cars.add(new Car());
        }

        outputView.outputTextOfResult();
        for (int i = 0; i < countOfMove; i++) {
            for (Car car : cars) {
                car.moveOrStop(moveStrategy.createMove());
                outputView.outputPositionOfCar(car.getPosition());
            }
            outputView.outputNextLine();
        }
    }
}
