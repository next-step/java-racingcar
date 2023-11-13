package study.race.model;

import study.race.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList;

    public Cars() {
        this.carList = new ArrayList<Car>();
    }

    public List<Car> carList() {
        return this.carList;
    }

    public void addCar() {
        this.carList.add(new Car());
    }
}
