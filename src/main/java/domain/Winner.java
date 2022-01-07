package domain;

import domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private final List<String> winner = new ArrayList<>();

    public List<String> getWinnerCar() {
        return Collections.unmodifiableList(winner);
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
