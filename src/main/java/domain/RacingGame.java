package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void playGame(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public List<String> getWinners() {
        int maxLocation = getMaxLocation();
        return filterWinners(maxLocation);
    }

    private int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    private List<String> filterWinners(int maxLocation) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
