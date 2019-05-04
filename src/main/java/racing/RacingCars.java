package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    List<RacingCar> racingCars;
    private int winnerPosition = 0;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public int count() {
        return racingCars.size();
    }

    public void add(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public List<RacingCar> getObjects() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<RacingCar> findWinners() {
        int maxCoordinate = maxCoordinate();
        return getWinners(maxCoordinate);
    }

    private int maxCoordinate() {
        int maxPosition = 0;
        for (RacingCar car : racingCars) {
            maxPosition = car.findMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<RacingCar> getWinners(int maxCoordinate) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.isMaxPosition(maxCoordinate)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int getWinnerPosition() {
        for (RacingCar car : racingCars)
            winnerPosition = car.findMaxPosition(winnerPosition);
        return winnerPosition;
    }

    public String getWinnerName() {
        getWinnerPosition();
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.isMaxPosition(winnerPosition))
                winnerNames.add(car.getName());
        }
        return String.join(Consts.FORMAT_COMMA, winnerNames);
    }

    public void randomMove(int randomValue) {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        for (RacingCar car : racingCars) {
            car.move(randomMovingStrategy.isMove(randomValue));
        }
    }
}
