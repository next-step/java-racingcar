package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int tryCount;

    public RacingGame(String name) {
        racingCars = CarFactory.from(name);
        tryCount = 0;
    }

    public RacingGame(String name, int tryCount) {
        racingCars = CarFactory.from(name);
        this.tryCount = tryCount;
    }

    public void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        Position maxPosition = getMaxPosition(racingCars);
        for (RacingCar racingCar : racingCars) {
            addWinner(racingCar, maxPosition, winners);
        }
        return winners;
    }

    private void addWinner(RacingCar racingCar, Position maxPosition, List<String> winners) {
        if (racingCar.isGreaterThanPosition(maxPosition)) {
            winners.add(racingCar.getName());
        }
    }

    private Position getMaxPosition(List<RacingCar> racingCars) {
        Position maxPosition = new Position();
        for (RacingCar racingCar : racingCars) {
            maxPosition = updateMaxPosition(racingCar, maxPosition);
        }
        return maxPosition;
    }

    private Position updateMaxPosition(RacingCar racingCar, Position maxPosition) {
        if (racingCar.isGreaterThanPosition(maxPosition)) {
            maxPosition = racingCar.getPosition();
        }
        return maxPosition;
    }

    public boolean isEnd() {
        if (tryCount == 0) {
            return false;
        }

        playGame();
        tryCount--;

        return true;
    }
}
