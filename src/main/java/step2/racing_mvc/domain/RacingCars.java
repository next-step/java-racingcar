package step2.racing_mvc.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars;

    public RacingCars(){
        this(new ArrayList<>());
    }

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }
    public void add(RacingCar car) {
        cars.add(car);
    }

    public int count() {
        return cars.size();
    }

    public RacingCar findOne(int carIndex) {
        return cars.get(carIndex);
    }

    public String findOneName(int carIndex) {
        return cars.get(carIndex).getName();
    }

    public boolean empty() {
        return cars.isEmpty();
    }
}