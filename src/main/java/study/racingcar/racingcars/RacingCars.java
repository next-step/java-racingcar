package study.racingcar.racingcars;

import study.racingcar.car.Car;
import study.racingcar.car.Engine;
import study.racingcar.view.ResultView;

import java.util.List;

/**
 * 경주에 참여하는 자동차를 보관하고 상태를 관리하는 책임
 */
public class RacingCars {

    private List<Car> cars;
    private Engine engineOfRacingCars;

    public RacingCars(List<Car> cars, Engine engine) {
        this.cars = cars;
        this.engineOfRacingCars = engine;
    }

    public void nextAttempt() {
        for (Car car : cars) {
            car.move(engineOfRacingCars);
        }
    }

    public void displayCurrentStatus(ResultView resultView) {
        resultView.displayCars(cars);
    }

    public <T> T export(RacingCarsExporter<T> exporter) {
        exporter.cars(cars);
        return exporter.build();
    }
}
