package step5.service;

import step5.domain.Car;
import step5.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private Cars cars;

    public Racing() {
    }

    public Racing(String carNames, int moveCount) {
        this.cars = registerCars(carNames);
        numberOfCarMove(moveCount);
    }

    public static Cars registerCars(String carNames) {
        return new Cars(carNames);
    }

    protected void race() {
        cars.moveOfCars();
    }

    public void numberOfCarMove(int moveCount) {
        IntStream.range(0,moveCount).forEach(i -> race());
    }

    public List<Car> getCarList() {
        return getObjectCars().getCars();
    }

    public Cars getObjectCars() {
        return cars;
    }

    public String getWinners() {
        return cars.getWinnerNames();
    }
}
