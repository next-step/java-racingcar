package domain;

import controller.CarNameHandler;

import java.util.ArrayList;

public class CarFactory {
    public static ArrayList<Car> getCars(String carNames) {
        ArrayList<Car> cars = new ArrayList<>();

        CarNameHandler carNameHandler = new CarNameHandler();
        String[] carNamesSplit = carNameHandler.splitCarNames(carNames);
        carNameHandler.checkCarNames(carNamesSplit);

        return cars;
    }
}
