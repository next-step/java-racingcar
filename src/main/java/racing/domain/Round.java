package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final RacingResult racingResult;
    private int totalRoundNumber;

    public Round(int totalRoundNumber) {
        this.totalRoundNumber = totalRoundNumber;
        this.racingResult = new RacingResult();
    }

    public void play(List<Car> cars) {
        while (inProgress()) {
            executeRound(cars);
            totalRoundNumber--;
        }
    }

    private void executeRound(List<Car> cars) {
        List<CarResult> roundResult = new ArrayList<>();

        for (Car car : cars) {
            car.move();
            roundResult.add(new CarResult(car.getName(), car.getDistance()));
        }

        racingResult.save(roundResult);
    }

    private boolean inProgress() {
        return totalRoundNumber > 0;
    }

    public RacingResult getRacingResult() {
        return racingResult;
    }
}
