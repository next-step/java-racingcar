package carRacing;

import carRacing.model.Car;
import carRacing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    List<Car> cars;
    OutputView outputView;

    public CarRacing() {
        this.cars = new ArrayList<>();
        outputView = new OutputView();
    }

    public void startRacing(int carCount, int racingCount) {
        enrollCars(carCount);

        System.out.println("실행 결과");
        for (int i = 0; i < racingCount; i++) {
            System.out.printf("try : %2d%n", i + 1 );
            excuteCycle();
            outputView.printResult(cars);
        }
    }

    private void excuteCycle() {
        cars.forEach(Car::moveByRandomInt);
    }

    private void enrollCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }
}
