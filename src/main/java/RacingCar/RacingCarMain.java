package RacingCar;

import RacingCar.domains.PositiveNumber;
import RacingCar.views.InputView;

public class RacingCarMain {
    public static void main(String[] args) {
        new PositiveNumber(InputView.askNumberOfCars());
        new PositiveNumber(InputView.askNumberOfRounds());
    }
}
