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

        createCars(countOfCar);
        int[] positionOfCars = new int[countOfCar];

        outputView.outputTextOfResult();
        for (int i = 0; i < countOfMove; i++) {
            playOneStage(countOfCar, positionOfCars);
            outputView.outputPositionOfCar(positionOfCars);
        }
    }

    private void createCars(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            cars.add(new Car());
        }
    }

    private void playOneStage(int countOfCar, int[] positionOfCars) {
        for (int i = 0; i < countOfCar; i++) {
            Car car = cars.get(i);
            car.moveOrStop(moveStrategy.createMove());
            positionOfCars[i] = car.getPosition();
        }
    }
}
