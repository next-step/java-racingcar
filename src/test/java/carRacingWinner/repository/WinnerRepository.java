package carRacingWinner.repository;

import carRacingWinner.entity.Car;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println();
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

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }
}
