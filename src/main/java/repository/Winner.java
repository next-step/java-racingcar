package repository;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winner = new ArrayList<>();

    public List<String> getWinnerCar() {
        return winner;
    }

    public void addWinnerCar(String winnerName) {
        winner.add(winnerName);
    }

    public void findWinnerCar(Car car, int maxDistance) {
        if (car.getDistance() == maxDistance) {
            addWinnerCar(car.getName());
        }
    }
}
