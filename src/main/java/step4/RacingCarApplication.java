package step4;

import step4.input.RacingCarInput;
import step4.output.RacingCarOutput;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = RacingCarInput.carNames();
        RacingCarOutput.printCarCount();
        int carCount = RacingCarInput.carCount();
        RacingCarOutput.printTryCount();
        int tryCount = RacingCarInput.tryCount();


        List<Car> cars = PrepareRacing.prepareCar(carCount);

        RacingCarOutput.printStartMessage();

        for (int i = 0; i < tryCount; i++) {
            List<Car> afterRaceCars = RacingStarter.start(cars);
            RacingCarOutput.printRacingResult(afterRaceCars);
        }
    }
}
