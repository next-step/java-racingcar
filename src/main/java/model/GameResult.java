package model;


import java.util.List;

public class GameResult {

    private final List<Car> cars;


    public GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

}
