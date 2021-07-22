package study.service;

import study.domain.Car;
import study.domain.Cars;

import java.util.List;

import static study.calculator.Common.*;

public class Racing {

    private Cars cars;

    public void setGameCount(int carCount, int roundCount) {
        this.cars = new Cars(carCount);

        for(int i = 0; i < roundCount; i++){
            movingCars(cars);
        }
    }

    private void movingCars(Cars cars) {

        for (Car car : cars.getCars()) {
            moveProgress(car);
            drawDisplay(car.getDistance().getMove());
        }
        System.out.print("\n");
    }

    private void moveProgress(Car car) {
        if(checkMoveable(createRandomNumber())){
            car.getDistance().move();
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

}
