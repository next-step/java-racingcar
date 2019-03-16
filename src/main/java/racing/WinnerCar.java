package racing;

import java.util.ArrayList;
import java.util.List;

public class WinnerCar {
    private List<String> winners = new ArrayList<>();
    private int maxPosition = 0;

    protected List<String> getWinners(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            this.comparePosition(racingCar, racingCar.getPosition());
        }
        return this.winners;
    }

    private void comparePosition(RacingCar racingCar, int carPosition) {
        if (carPosition < this.maxPosition) {
            return;
        }

        if (carPosition > this.maxPosition) {
            this.maxPosition = carPosition;
            this.removeWinner();
        }
        this.addWinner(racingCar.getName());
    }

    private void removeWinner() {
        this.winners = new ArrayList<>();
    }

    private void addWinner(String name) {
        this.winners.add(name);
    }
}
