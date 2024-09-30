package racingcar;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        int cntOfCar = InputView.inputCountOfCar();

        int timesOfRun = InputView.inputTimesOfRun();

        List<Car> cars = CarManager.createCarsByCnt(cntOfCar);

        runAndPrintResult(timesOfRun, cars);
    }

    private static void runAndPrintResult(int timesOfRun, List<Car> cars) {

        for (int i = 0; i < timesOfRun; i++) {
            runNthCarGame(cars);
            OutputView.printMileage(cars, i == 0 ? true : false);
        }
    }

    private static void runNthCarGame(List<Car> cars) {
        for (Car car : cars) {
            car.run(CarMoveUtil.isMove());
        }
    }
}
