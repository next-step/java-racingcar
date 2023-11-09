package step3.view;

import step3.model.Car;

import java.util.List;

public class RaceResultView {

    private final List<Car> cars;
    private static final String SIGN = "-";

    public RaceResultView(List<Car> cars) {
        this.cars = cars;
    }

    public void show() {
        cars.forEach(car -> System.out.println(SIGN.repeat(car.getCurrentStatus())));
    }
}
