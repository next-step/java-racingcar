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

        List<Car> cars = PrepareRacing.prepareCar(carNames);

        RacingCarOutput.printStartMessage();

        for (int i = 0; i < tryCount; i++) {
            List<Car> afterRaceCars = RacingStarter.start(cars);
            RacingCarOutput.printRacingResult(afterRaceCars);
        }
    }
}
