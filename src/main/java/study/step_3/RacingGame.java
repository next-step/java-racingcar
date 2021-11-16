package study.step_3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars = new ArrayList<>();
    private int numberOfCars;
    private int numberOfTrial;

    public RacingGame(Input input) {
        this.numberOfCars = input.getNumberOfCars();
        this.numberOfTrial = input.getNumberOfTrial();

        for (int i = 0; i < this.numberOfCars; i++) {
            this.racingCars.add(new RacingCar());
        }
    }

    public void start() {
        for (int i = 0; i < this.numberOfTrial; i++) {
            for (RacingCar racingCar : this.racingCars) {
                racingCar.move();
            }
        }
    }

    public int numberOfCars() {
        return this.racingCars.size();
    }

    public int numberOfTrial() {
        return this.numberOfTrial;
    }
}
