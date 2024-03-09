package step3;

import step3.view.InputView;

public class CarRaceApplication {
    public static void main(String[] args) {
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        CarRacing carRacing = new CarRacing(InputView.inputNumberOfCars(), randomMoveStrategy);
        carRacing.racingStart(InputView.inputNumberOfAttempts());
    }
}
