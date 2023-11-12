package racing.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.view.ResultView;

public class Cars {
    private final List<RacingCar> cars;

    public Cars(List<RacingCar> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }
    public void raceAllCars() {
        for (RacingCar car : cars) {
            car.race(car.getRandomInt());
            ResultView.showRaceProgress(car);
        }
    }
    public static List<RacingCar> getWinners(List<RacingCar> cars) {
        return cars.stream()
                .filter(car -> car.isSameProgress(getTopSpeed(cars)))
                .collect(Collectors.toList());
    }
    public static int getTopSpeed(List<RacingCar> cars) {
        int max = 0;
        for (RacingCar car : cars) {
            max = car.max(max);
        }
        return max;
    }
}
