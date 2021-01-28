package domain;

import controller.CarNameHandler;

import java.util.ArrayList;

public class CarFactory {
    public ArrayList<Car> generateCars(String carNames) {
        CarNameHandler carNameHandler = new CarNameHandler();
        String[] carNamesSplit = carNameHandler.splitCarNames(carNames);
        carNameHandler.checkCarNames(carNamesSplit);

        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNamesSplit) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
