package racingcar;

import java.util.List;

public class Winner {

    int maxLength = 0;
    String winner = "";
    public void winnerDecision(List<RacingCar> racingCars){

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
