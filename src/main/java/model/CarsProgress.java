package model;

import domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsProgress {

    private List<Cars> carsList;

    public CarsProgress(String numberOfCarsString) {
        int numberOfCars = Integer.parseInt(numberOfCarsString);
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
