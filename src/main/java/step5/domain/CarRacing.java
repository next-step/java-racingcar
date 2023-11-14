package step5.domain;

import java.util.List;

public class CarRacing {

    private Cars cars;

    public Cars getCars() {
        return this.cars;
    }

    public void createCarsOf(String[] nameOfCars) {
        cars = new Cars(nameOfCars);
    }

    public void moveCar(int randomNum, int carNo) {
        cars.moveCarBy(randomNum, carNo);
    }

    public List<String> findWinners() {
        return cars.findCarNamesBy(cars.findMaxPosition());
    }
}
