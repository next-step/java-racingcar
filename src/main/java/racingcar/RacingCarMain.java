package racingcar;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {

        List<String> namesOfCar = InputView.inputNamesOfCar();

        int timesOfRun = InputView.inputTimesOfRun();

        List<Car> cars = CarManager.createCarsByCnt(namesOfCar);

        runAndPrintResult(timesOfRun, cars);
    }

    private static void runAndPrintResult(int timesOfRun, List<Car> cars) {

        for (int i = 0; i < timesOfRun; i++) {
            runNthCarGame(cars);
            OutputView.printMileage(cars, i == 0 ? true : false);
        }

        OutputView.printWinner(cars);
    }

    private static void runNthCarGame(List<Car> cars) {
        for (Car car : cars) {
            car.run(CarMoveUtil.isMove());
        }
    }
}