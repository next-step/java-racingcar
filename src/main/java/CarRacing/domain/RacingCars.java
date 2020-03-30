package CarRacing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(final List<Car> carList) {
        this.racingCars = carList;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void race(final RacingStrategy racingStrategy) {
        for (Car car : racingCars) {
            car.move(racingStrategy);
        }
    }

    public int getMaxPosition() {
        return this.racingCars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow(() -> new RuntimeException("Winner does not exist"));
    }

    public List<String> getWinnerWithMaxPosition(final int maxPosition) {
        return this.racingCars
                .stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
