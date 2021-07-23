package racing.view;

import racing.car.Car;
import racing.car.Cars;

public interface ResultView {
    void printResultTitle();

    void printAllCarLocation(Cars car);

    void printCarLocation(Car car);

    void printException(Exception e);
}
