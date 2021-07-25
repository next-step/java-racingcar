package racing.view;

import racing.domain.car.BasicCar;
import racing.domain.car.Car;
import racing.domain.car.Cars;

public interface ResultView {
    void printResultTitle();

    void printAllCarLocation(Cars cars);

    void printCarLocation(Car car);

    void printException(Exception e);

    void printWinners(Cars cars);
}
