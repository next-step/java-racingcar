package step3;

import java.util.List;

public class CarStadium {

    private final Referee referee;
    private final List<Car> cars;

    public CarStadium(Referee referee, List<Car> cars) {
        this.referee = referee;
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

    public int carsCount() {
        return cars.size();
    }
}
