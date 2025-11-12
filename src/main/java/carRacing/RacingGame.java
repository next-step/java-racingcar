package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars;

    public RacingGame(String name) {
        racingCars = CarFactory.initRacingCars(name);
    }

    public void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> selectWinner() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(racingCars);
        for (RacingCar racingCar : racingCars) {
            addWinner(racingCar, maxPosition, winners);
        }
        return winners;
    }

    private void addWinner(RacingCar racingCar, int maxPosition, List<String> winners) {
        if (racingCar.isGreaterThanPosition(maxPosition)) {
            winners.add(racingCar.getName());
        }
    }

    private int getMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            maxPosition = updateMaxPosition(racingCar, maxPosition);
        }
        return maxPosition;
    }

    private int updateMaxPosition(RacingCar racingCar, int maxPosition) {
        if (racingCar.isGreaterThanPosition(maxPosition)) {
            maxPosition = racingCar.getPosition();
        }
        return maxPosition;
    }
}
