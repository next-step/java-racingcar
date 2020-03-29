package CarRacing.domain;

import CarRacing.view.RacingView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    final private RacingStrategy racingStrategy;
    final private RacingCars racingCars;
    final private int racingTime;

    public RacingGame(final List<Car> carList, final int racingTime) {
        this.racingTime = racingTime;
        this.racingCars = new RacingCars(carList);
        this.racingStrategy = new MovingStrategy();
    }

    public void raceStart() {
        for (int i = 0; i < this.racingTime; i++) {
            this.racingCars.race(this.racingStrategy);
            RacingView.makeCarsCurrentStatusToString(this.racingCars);
        }
    }

    public List<String> getRacingWinner() {
        return getWinnerWithMaxPosition(getMaxPosition());
    }

    private int getMaxPosition() {
        return this.racingCars.getRacingCars()
                .stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElseThrow(() -> new RuntimeException("Winner does not exist"));
    }

    private List<String> getWinnerWithMaxPosition(final int maxPosition) {
        return this.racingCars.getRacingCars()
                .stream()
                .filter(car -> car.getCurrentPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
