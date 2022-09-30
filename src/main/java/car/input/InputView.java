package car.input;

import car.domain.Car;

import java.util.List;

public interface InputView {
    List<Car> enterCar();
    int enterTryCount();
}
