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

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void showCarsLocation() {
        cars.forEach(Car::showNowLocation);
    }

    public int getLimitTime() {
        return limitTime;
    }

    public int carsCount() {
        return cars.size();
    }
}
