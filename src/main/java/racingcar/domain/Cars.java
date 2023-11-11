package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private List<Car> cars;

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

    public void moveAllCar() {
        Strategy numberStrategy = new NumberStrategy();
        for (Car car : cars) {
            car.stopOrMove(numberStrategy);
        }
    }

    public final List<Car> getAllCar() {
        List<Car> copyCars = new ArrayList<>();
        for (Car car : cars) {
            copyCars.add(car.clone());
        }
        return copyCars;
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
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getMoveCount() == winnerMoveCount) {
                winners.add(car.getName());
            }
        }
    }
}
