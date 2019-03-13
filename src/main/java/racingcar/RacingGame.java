package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars;

    RacingGame(List<String> carNames) {
        this.racingCars = new ArrayList<>();
        this.initRacingCars(carNames);
    }

    private void initRacingCars(List<String> carNames) {
        carNames.forEach(carName -> this.racingCars.add(new RacingCar(carName)));
    }

    public List<RacingCar> play() {
        this.racingCars.forEach(RacingCar::moveRandomly);

        return this.racingCars;
    }

    public List<RacingCar> determineWinners() {
        final int carCount = racingCars.size();

        Collections.sort(racingCars);
        List<RacingCar> winners = new ArrayList<>();

        winners.add(this.racingCars.get(carCount-1));

        for (int i = carCount - 2; i >= 0; i--) {
            if (racingCars.get(i).compareTo(racingCars.get(i+1)) == 0) {
                winners.add(racingCars.get(i));
            }

            if (racingCars.get(i).compareTo(racingCars.get(i+1)) < 0) {
                break;
            }
        }

        return winners;
    }
}
