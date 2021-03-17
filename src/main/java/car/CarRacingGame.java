package car;

import car.model.UserInput;
import car.view.InputView;
import car.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public void play() {
        UserInput input = InputView.receiveInput();

        addCars(input.carCount);

        for (int i = 0; i < input.totalRound; ++i) {
            runRound();
            ResultView.printStatus(racingCars);
        }
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
