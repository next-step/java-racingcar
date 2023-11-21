package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public static final int BOUND = 10;
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars raceOnce(RandomService randomService) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move(randomService.nextInt(BOUND));
        }
        return this;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        long finishLine = findMaxPosition();
        for (RacingCar racingCar : this.racingCars) {
            addWinnerTo(racingCar, finishLine, winners);
        }
        return winners;
    }

    private void addWinnerTo(RacingCar racingCar, long finishLine, List<String> winners) {
        if (isWinner(racingCar, finishLine)) {
            winners.add(racingCar.getCarName());
        }
    }

    private boolean isWinner(RacingCar racingCar, long finishLine) {
        return racingCar.isLocated(finishLine);
    }

    private long findMaxPosition() {
        long maxPosition = 0;
        for (RacingCar racingCar : this.racingCars) {
            maxPosition = racingCar.updateMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
