package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

import static study.racing.common.Common.createRandomNumber;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int count) {
        for(int i = 0; i < count; i++){
            cars.add(readyToCar());
        }
    }

    public Cars(int count, String[] carName) {
        for(int i = 0; i < count; i++){
            cars.add(readyToCar(carName[i]));
        }
    }

    private Car readyToCar(String carName) {
        return Car.createCar(carName);
    }

    private Car readyToCar() {
        return Car.createCar();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveTheCar(){
        cars.forEach(car -> car.moveTheCar(createRandomNumber()));
    }
}
