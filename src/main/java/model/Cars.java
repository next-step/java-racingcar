package model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames, MoveStrategy moveStrategy) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName, moveStrategy));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> moveAllCars() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public List<Car> findWinningCar() {
        List<Car> winningCars = new ArrayList<>();
        List<Integer> positions = getPositions();
        int maxPosition = positions.stream().max(Integer::compareTo).orElse(0);
        for (Car car : cars) {
            addIfWinningCar(winningCars, car, maxPosition);
        }
        return winningCars;
    }

    void addIfWinningCar(List<Car> winningCars, Car car, int maxPosition) {
        if (car.isSamePosition(maxPosition)) {
            winningCars.add(car);
        }
    }
}
