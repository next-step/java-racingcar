package study.racing.service;

import study.racing.validation.Validation;
import study.racing.domain.Car;
import study.racing.domain.Cars;

import java.util.List;

import static study.racing.common.Common.*;

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
        if(checkMoveableCar(createRandomNumber())){
            car.getDistance().move();
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

}
