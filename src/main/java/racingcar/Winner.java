package racingcar;

import java.util.List;

public class Winner {

    public void winnerDecision(List<RacingCar> racingCars) {
        int maxLength = 0;
        String winner = "";

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxLength) {
                maxLength = racingCar.getPosition();
            }
        }
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxLength) {
                winner = winner.concat(" " + racingCar.getCarName());
            }
        }
    }
}
