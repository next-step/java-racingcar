package carRacing;

import carRacing.model.Car;
import carRacing.util.RandomIntUtil;
import carRacing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    List<Car> cars;
    OutputView outputView = new OutputView();

    public CarRacing() {
        cars = new ArrayList<>();
    }

    public void startRacing(int carCount, int racingCount) {
        makeCar(carCount);

        System.out.println("실행 결과");
        for (int i = 0; i < racingCount; i++) {
            excuteCycle();
            outputView.printResult(cars);
        }


    }

    private void excuteCycle() {
        for (Car car : cars) {
            if (RandomIntUtil.getRandomInt() >= 4)
                car.move();
        }
    }

    private void makeCar(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
    }
}
