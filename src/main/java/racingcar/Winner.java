package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public List<String> winnerDecision(List<RacingCar> racingCars) {
        List<String> winner = new ArrayList<>();
        int maxPosition = 0;

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }

        for (RacingCar racingCar : racingCars) {
            if (racingCar.isSamePosition(maxPosition)) {
                winner.add(racingCar.getCarName());
            }
        }

        return winner;
    }
}
