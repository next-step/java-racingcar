package model;

import ui.GameUI;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    public void race(int tryCount, List<Car> cars) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            GameUI.printCarsStatus(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.tryMoveForward(RandomNumberGenerator.random());
        }
    }

    public List<String> findWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
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

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(),  maxPosition);
        }

        return maxPosition;
    }
}
