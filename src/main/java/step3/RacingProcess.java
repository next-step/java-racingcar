package step3;

import step3.model.Car;
import step3.model.Cars;
import step3.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingProcess {
    private final int carCount;
    private final int periodCount;

    public RacingProcess(int carCount, int periodCount) {
        countValidation(carCount);
        countValidation(periodCount);

        this.carCount = carCount;
        this.periodCount = periodCount;
    }

    public void racingStart() {
        Cars cars = new Cars(generateCars());

        cars.goForward(periodCount);
    }

    private List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i <= carCount; i++) {
            Car car = new Car(0);
            cars.add(car);
        }

        return cars;
    }

    private void countValidation(int count) {
        if (count < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }
}
