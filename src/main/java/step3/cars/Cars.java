package step3.cars;

import step3.car.Car;

public interface Cars {

    Cars carsWithAddCar(Car car);

    Cars carsWithRemoveCar(Car car);

    Cars carsWithTurnUsed();

}
