package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {
    public static final int BOUND = 10;
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void raceOnce(RandomService randomService) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.move(randomService.nextInt(BOUND));
        }
    }

    public String createGameResult() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (RacingCar racingCar : this.racingCars) {
            stringJoiner.add(racingCar.getCarName() + " : " + racingCar.movingDistance());
        }
        return stringJoiner.add("\n").toString();
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
}
