package racing.domain;

import java.util.Comparator;
import java.util.List;

public class RacingRanking {
    private List<RacingCar> cars = null;

    public RacingRanking(List<RacingCar> cars) {
        this.cars = cars;
    }

    public String[] getWinners() {
        int maxScore = getRacingMaxScore(cars);
        return cars.stream()
                .filter(car -> car.isPosition(maxScore))
                .map(car -> car.getName())
                .toArray(String[]::new);
    }

    private int getRacingMaxScore(List<RacingCar> cars) {
        return cars.stream()
                    .max(Comparator.comparing(RacingCar::getCurrentPosition))
                    .map(car -> car.getCurrentPosition())
                    .get();
    }
}
