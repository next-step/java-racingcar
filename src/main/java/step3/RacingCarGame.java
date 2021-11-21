package step3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> racingCarList;
    private Attempt attempt;

    public boolean ready(int carCount, int attemptCount) {
        racingCarList = new ArrayList<>(carCount);
        while(racingCarList.size() != carCount) {
            racingCarList.add(new RacingCar());
        }

        attempt = new Attempt(attemptCount);
        if(isRacingCarReady(carCount) && isAttemptReady(attemptCount)) {
            return true;
        }
        return false;
    }

    public boolean isRacingCarReady(int carCount) {
        if(racingCarList.size() == carCount) {
            return true;
        }
        return false;
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
        Iterator iterator = racingCarList.iterator();
        while(iterator.hasNext()) {
            RacingCar racingCar = (RacingCar) iterator.next();
            racingCar.move();
        }
        attempt.make();
    }
}
