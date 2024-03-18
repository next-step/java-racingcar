package carRacingWinner.repository;

import carRacingWinner.entity.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WinnerRepository {

    private List<Car> cars;

    public void addCar(Car car) {
        if (cars == null)
            this.cars = new ArrayList<>();
        this.cars.add(car);
    }

    public void presentLocation() {
        for (Car car : cars) {
            car.print();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
