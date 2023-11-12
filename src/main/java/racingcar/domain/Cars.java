package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    public List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        initializeCars(carNames);
    }

    private void initializeCars(String[] carNames) {
        checkCarNumber(carNames.length);
        for (String carName : carNames) {
            this.addCar(new Car(carName));
        }
    }

    private void checkCarNumber(int carNumber) {
        if (carNumber <= 0) {
            throw new IllegalArgumentException("Input positive car number.");
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public final List<Car> moveAllCar() {
        List<Car> newCars = new ArrayList<>();
        for (Car car : cars) {
            Car newCar = car.stopOrMove(new NumberStrategy());
            newCars.add(newCar);
        }
        cars = newCars;
        return newCars;
    }

    public int getNumberOfCar() {
        return cars.size();
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        cars.sort(Comparator.comparingInt(Car::getMoveCount).reversed());
        int winnerMoveCount = cars.get(0).getMoveCount();
        decisionWinner(winners, winnerMoveCount);
        return winners;
    }

    private void decisionWinner(List<String> winners, int winnerMoveCount) {
        for (Car car : cars) {
            if (car.getMoveCount() == winnerMoveCount) {
                winners.add(car.getName());
            }
        }
    }
}
