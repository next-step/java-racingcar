package study.racing.domain;

import static study.racing.common.Common.createRandomNumber;
import static study.racing.common.Common.splitCarsName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int count) {
        for(int i = 0; i < count; i++){
            cars.add(readyToCar());
        }
    }

    public Cars(String carName) {
        Arrays.asList(splitCarsName(carName)).forEach(name -> cars.add(readyToCar(name)));
    }

    public int getMaxMoveDistance() {
        int max = 0;
        for (Car car : cars) {
            max = car.maxDistance(max);
        }
        
        return max;
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

    public List<Car> getWinners() {
        return cars.stream()
            .filter(car -> car.isWinner(getMaxMoveDistance()))
            .collect(Collectors.toList());
    }
}
