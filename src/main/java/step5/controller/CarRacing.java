package step5.controller;

import step5.model.Car;
import step5.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private int numOfTries;
    private String carNames;
    private String inputs[];
    private Cars cars;

    public CarRacing(String carNames, int numOfTries) {
        this.carNames= carNames;
        this.numOfTries = numOfTries;

        cars = returnCarsObj(carNames.split(","));
    }

    public Cars gameStart() {
        for (int i = 0; i < numOfTries; i++) {
            cars.carsMove();
        }
        return cars;
    }

    static Cars returnCarsObj(String[] inputs) {
        List<Car> carNameList = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            carNameList.add(new Car(inputs[i]));
        }

        return Cars.makeCars(carNameList);
    }

}


