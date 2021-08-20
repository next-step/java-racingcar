package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.RandomMoveStrategyImpl;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(new CarName(name));
            cars.add(car);
        }
        this.cars = cars;
    }

    public void roundOneTry() {
        this.cars.forEach(car -> {
            boolean isMove = car.moveOperator(new RandomMoveStrategyImpl());
            car.move(isMove);
        });
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
