package study.racingcar;

import study.racingcar.creator.RacingCarCreator;
import study.racingcar.model.Car;
import study.racingcar.output.ResultView;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGame {
    private final int carCount;
    private final int time;
    private final ResultView resultView;

    public RacingGame(int carCount, int time, ResultView resultView) {
        this.carCount = carCount;
        this.time = time;
        this.resultView = resultView;
    }

    public void start() {
        List<Car> cars = makeRacingCar();

        resultView.printInit();

        printStandbyStatus(cars);
        runCarsAndPrintStatus(cars);
    }

    private void printStandbyStatus(List<Car> cars) {
        resultView.print(cars);
    }

    private void runCarsAndPrintStatus(List<Car> cars) {
        for (int index = 0; index < time; index++) {
            cars.forEach(Car::run);
            resultView.print(cars);
        }
    }

    private List<Car> makeRacingCar() {
        return RacingCarCreator.create(this.carCount);
    }
}
