package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarService {
    private final List<Car> cars;
    private final Random random;

    public RacingCarService(int numOfCars) {

        this.cars = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            cars.add(new Car());
        }
        this.random = new Random();
    }

    public void race(int numOfRounds) {
        for (int i = 0; i < numOfRounds; i++) {
            for (Car car : cars) {
                if (random.nextInt(10) > 4){
//                    car.move();
                }
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
