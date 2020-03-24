package CarRacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    public RacingCars(final String[] carNameArr) {
        this.racingCars = Arrays.stream(carNameArr)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void race(final RacingStrategy racingStrategy) {
        for (Car car : racingCars) {
            car.move(racingStrategy);
        }
    }

    public void showCurrentStatus() {
        final StringBuilder sb = new StringBuilder();
        for (Car car : racingCars) {
            sb.append(StringUtils.makeGauge(car.getCurrentPosition()));
        }

        System.out.println(sb.toString());
    }
}
