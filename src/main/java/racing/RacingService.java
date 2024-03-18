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
        for (int i = 0; i < racingCars.getCarList().size(); i++) {
            oneCarRace(racingCars, i);
        }
    }

    private static void oneCarRace(RacingCars racingCars, int idx) {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        if (RacingValidator.isMovable(randomNumber)) {
            Location newCarLocation = moveForward(racingCars.getCarList().get(idx));
            racingCars.getCarList().remove(idx);
            racingCars.getCarList().add(idx, new Car(newCarLocation));
        }
    }

    public static Location moveForward(Car car) {
        Location newCarLocation = null;
        try {
            newCarLocation = car.getCarLocationInfo().moveForward();
        } catch (CarLocationException e) {
            System.err.println("예외 발생:" + e.getMessage());
        }
        return newCarLocation;
    }

}
