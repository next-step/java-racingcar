package racingCar.view.formatter;

import racingCar.domain.Car;

public class OutputFomatter {

    public String toCarName(Car car) {
        return car.getName();
    }

    public String toMovement(Car car) {
        return "-".repeat(car.getDistance());
    }
}
