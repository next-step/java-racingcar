package study.step4.model.view;

import java.util.List;
import study.step4.model.car.Car;
import study.step4.model.car.Cars;

public class Result {

    List<Car> racingGameCars;

    public Result(Cars cars) {
        racingGameCars = cars.getRacingGameCars();
    }

    public List<Car> getRacingGameCars() {
        return racingGameCars;
    }
}
