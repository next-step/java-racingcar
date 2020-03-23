package CarRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    final private List<Car> racingCars = new ArrayList<>();

    public RacingCars(final int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.racingCars.add(new Car());
        }
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
            sb.append(StringUtils.gaugeMaker(car.getCurrentPosition()));
        }

        System.out.println(sb.toString());
    }
}
