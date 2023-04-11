package study.step3.domain;

import study.step3.view.InputView;
import study.step3.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private MoveStrategy moveStrategy;

    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing(new RandomMove());
        carRacing.play();
    }

    public CarRacing(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        int countOfCar = inputView.inputCountOfCar();
        int countOfMove = inputView.inputCountOfMove();

        Cars cars = createCars(countOfCar);

        outputView.outputTextOfResult();
        for (int i = 0; i < countOfMove; i++) {
            cars.moveForward(moveStrategy);
            outputView.outputPositionOfCar(cars.toPositionOfCars());
        }
    }

    private Cars createCars(int countOfCar) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < countOfCar; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }
}
