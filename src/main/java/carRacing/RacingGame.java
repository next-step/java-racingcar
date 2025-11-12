package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String[] names) {
        for (int i = 0; i < names.length; i++) {
            racingCars.add(new RacingCar(names[i]));
        }
    }

    public void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    private void carNameSizeCheck(String name) {
        if (name.length() > 5) {
            throw new RuntimeException();
        }
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
        if (racingCar.getPosition() >= maxPosition) {
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
        if (racingCar.getPosition() >= maxPosition) {
            maxPosition = racingCar.getPosition();
        }
        return maxPosition;
    }
}
