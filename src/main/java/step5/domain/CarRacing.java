package step5.domain;

import step5.domain.Cars;

import java.util.List;

public class CarRacing {

    private Cars cars;

    public Cars getCars() {
        return this.cars;
    }

    public void createCarsOf(String[] nameOfCars) {
        cars = new Cars(nameOfCars);
    }

    public void createCarsOf(List<String> nameOfCars, List<Integer> positions) {
        cars = new Cars(nameOfCars, positions);
    }

    public void moveCar(int randomNum, int carNo) {
        cars.moveCarBy(randomNum, carNo);
    }

    public List<String> findWinners() {
        return cars.findCarNamesMovingLongest(cars.findMaxPosition());
    }
}
