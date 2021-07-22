package study.service;

import study.validation.Validation;
import study.domain.Car;
import study.domain.Cars;

import java.util.List;

import static study.common.Common.*;

public class Racing {

    private Cars cars;

    public void setGameCount(String carCount, String roundCount) {

        validationValues(carCount, roundCount);

        this.cars = new Cars(toInt(carCount));

        for(int i = 0; i < toInt(roundCount); i++){
            movingCars(cars);
        }
    }

    private void validationValues(String carCount, String roundCount) {
        Validation.checkValue(carCount);
        Validation.checkValue(roundCount);
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
