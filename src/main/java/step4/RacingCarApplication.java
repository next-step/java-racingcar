package step4;

import step4.input.RacingCarInput;
import step4.output.RacingCarOutput;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarOutput.printCarNames();
        String[] carNames = RacingCarInput.carNames();
        RacingCarOutput.printTryCount();
        int tryCount = RacingCarInput.tryCount();

        List<Car> cars = CarFactory.prepareCar(carNames);

        RacingCarOutput.printStartMessage();

        for (int i = 0; i < tryCount; i++) {
            RacingSupport.start(cars);
            RacingCarOutput.printRacingResult(cars);
        }

        String winner = WinnerSupport.chooseWinner(cars);
        RacingCarOutput.printWinner(winner);
    }
}
