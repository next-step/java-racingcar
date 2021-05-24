package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> victor(List<RacingCar> racingCars) {
        int maxPosition = 0;

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }

        List<String> winner = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.maxPosition(maxPosition)) {
                winner.add(racingCar.getCarName());
            }
        }
        return winner;
    }
}
