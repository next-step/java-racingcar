package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class WinnerCar {

    public List<String> getWinners(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = this.getMaxPosition(racingCars);

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() == maxPosition) {
                winners.add(racingCar.getCarName());
            }
        }
        return winners;
    }

    private int getMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            int carPosition = racingCar.getPosition();
            maxPosition = carPosition > maxPosition ? carPosition : maxPosition;
        }
        return maxPosition;
    }
}
