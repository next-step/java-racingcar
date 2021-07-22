package step3;

import java.util.List;

public class CarStadium {

    private final int limitTime;
    private final List<Car> cars;

    public CarStadium(int limitTime, List<Car> cars) {
        this.limitTime = limitTime;
        this.cars = cars;
    }

    public void enterCar(Car car) {
        cars.add(car);
    }
}
