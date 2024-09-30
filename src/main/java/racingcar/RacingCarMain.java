package racingcar;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        int cntOfCar = InputView.inputCountOfCar();

        int timesOfRun = InputView.inputTimesOfRun();

        List<Car> cars = CarManager.createCarsByCnt(cntOfCar);

        run(timesOfRun, cars);

        OutputView.printMileage(cars, timesOfRun);
    }

    private static void run(int timesOfRun, List<Car> cars) {
        for (int i = 0; i < timesOfRun; i++) {
            cars.forEach(Car :: run);
        }
    }
}
