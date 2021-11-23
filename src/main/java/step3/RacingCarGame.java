package step3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> racingCarList;
    private Attempt attempt;

    public boolean ready(int carCount, int attemptCount) {
        racingCarList = new ArrayList<>(carCount);
        while (racingCarList.size() != carCount) {
            racingCarList.add(new RacingCar());
        }

        attempt = new Attempt(attemptCount);

        return isRacingCarReady(carCount) && isAttemptReady(attemptCount);
    }

    public boolean isRacingCarReady(int carCount) {
        return racingCarList.size() == carCount;
    }

    public boolean isAttemptReady(int attemptCount) {
        return attempt.isEqualNumber(attemptCount);
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public Attempt getAttempt() {
        return attempt;
    }

    public void play() {
        for(RacingCar racingCar : racingCarList) {
            racingCar.move();
        }
        attempt.make();
    }
}
