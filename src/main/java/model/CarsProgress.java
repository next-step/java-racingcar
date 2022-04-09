package model;

import controller.InputService;
import domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsProgress {

    private List<Cars> carsList;

    public CarsProgress(int numberOfCars) {
        carsList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            Cars cars = new Cars();
            cars.setDistanceTraveled(0);
            carsList.add(cars);
        }
    }

    public List<Cars> getCarsList() {
        return carsList;
    }
}
