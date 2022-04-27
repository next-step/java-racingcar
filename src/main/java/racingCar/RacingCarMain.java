package racingCar;

import racingCar.domains.PositiveNumber;
import racingCar.views.InputView;

public class RacingCarMain {
    public static void main(String[] args) {
        new PositiveNumber(InputView.askNumberOfCars());
        new PositiveNumber(InputView.askNumberOfRounds());
    }
}
