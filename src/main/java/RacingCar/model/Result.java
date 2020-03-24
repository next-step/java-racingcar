package RacingCar.model;

import java.util.List;

public class Result {
    private List<Car> cars;

    public Result(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
