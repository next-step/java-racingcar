package model;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carNameInput) {
        cars = new ArrayList<>();

        String[] carNames = parseCarNames(carNameInput);
        for (String carName : carNames) {
            cars.add(new Car(1, carName));
        }
    }

    private String[] parseCarNames(String carNameInput) {
        return carNameInput.split(",");
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.tryMoveForward(RandomNumberGenerator.random());
        }
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(),  maxPosition);
        }

        return maxPosition;
    }

    public List<String> getWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (isWinner(car.getPosition(), maxPosition)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private boolean isWinner(int position, int maxPosition) {
        return position == maxPosition;
    }
}
