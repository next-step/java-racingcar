package step3;

import step3.input.RacingCarInput;
import step3.output.RacingCarOutput;

public class RacingCar {
    public static void main(String[] args) {
        RacingCarOutput.printCarCount();
        Integer carCount = RacingCarInput.carCount();
        RacingCarOutput.printTryCount();
        Integer tryCount = RacingCarInput.tryCount();

        Car[] preparedCar = RacingSupport.prepareCar(carCount);

        RacingCarOutput.printResultStartMessage();

        for (int i = 0; i < tryCount; i++) {
            Car[] afterRaceCars = RacingSupport.raceEachCar(preparedCar);
            RacingCarOutput.printRacingResult(afterRaceCars);
        }
    }
}
