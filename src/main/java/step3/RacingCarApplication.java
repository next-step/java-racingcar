package step3;

import java.util.List;
import step3.input.RacingCarInput;
import step3.output.RacingCarOutput;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarOutput.printCarCount();
        Integer carCount = RacingCarInput.carCount();
        RacingCarOutput.printTryCount();
        Integer tryCount = RacingCarInput.tryCount();

        List<Car> cars = RacingSupport.prepareCar(carCount);

        RacingCarOutput.printResultStartMessage();

        for (int i = 0; i < tryCount; i++) {
            List<Car> afterRaceCars = RacingSupport.raceEachCar(cars);
            RacingCarOutput.printRacingResult(afterRaceCars);
        }
    }
}
