package car;

import car.model.UserInput;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {
    public static final int MOVE_THRESHOLD = 4;

    private List<RacingCar> racingCars = new ArrayList<>();

    public void play() {
        UserInput input = InputView.receiveInput();

        addCars(input.carCount);

        for (int i = 0; i < input.totalRound; ++i) {
            runRound();
        }

        // todo: print result
    }

    private void addCars(int carCount) {
        for (int i = 0; i < carCount; ++i) {
            racingCars.add(new RacingCar());
        }
    }

    private void runRound() {
        racingCars.forEach(RacingCar::tryMoving);
    }
}
