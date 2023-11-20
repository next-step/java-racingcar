package racingcar.domain;

import static racingcar.constant.Constant.BOUND;
import static racingcar.constant.Constant.COLON;
import static racingcar.constant.Constant.ENTER;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {

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
        StringJoiner stringJoiner = new StringJoiner(ENTER);
        for (RacingCar racingCar : this.racingCars) {
            stringJoiner.add(racingCar.getCarName() + COLON + racingCar.movingDistance());
        }
        return stringJoiner.add(ENTER).toString();
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
