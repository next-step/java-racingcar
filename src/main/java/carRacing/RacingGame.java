package carRacing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public List<RacingCar> initRacingCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }

    public void playGame() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(RandomUtil.getRandomValue());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
