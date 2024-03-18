package carRacingWinner.repository;

import carRacingWinner.entity.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WinnerRepository {

    private List<Car> cars;

    private void createCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String name) {
        if (cars == null)
            createCars();
        this.cars.add(new Car(name));
    }

    public void presentLocation() {
        for (Car car : cars) {
            car.print();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void makeCars(List<String> names) {
        if (cars == null)
            createCars();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }
}
