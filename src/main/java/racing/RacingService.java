package racing;

import exception.CarLocationException;
import ui.ResultView;
import util.RacingValidator;
import util.RandomNumberGenerator;

public class RacingService {


    public static void race(int carCount, int tryCount) {
        RacingCars racingCars = new RacingCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            startRace(racingCars);
            ResultView.showRaceResult(racingCars, i);
        }
    }

    private static void startRace(RacingCars racingCars) {
        for (int i = 0; i < racingCars.getCarArr().length; i++) {
            oneCarRace(racingCars, i);
        }
    }

    private static void oneCarRace(RacingCars racingCars, int idx) {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        if (RacingValidator.isMovable(randomNumber)) {
            moveForward(racingCars.getCarArr()[idx]);
        }
    }

    public static void moveForward(Car car) {
        try {
            car.getCarLocationInfo().moveForward();
        } catch (CarLocationException e) {
            System.err.println("예외 발생:" + e.getMessage());
        }
    }

}
