package racing;

import ui.ResultView;
import util.RacingValidator;
import util.RandomNumberGenerator;

public class RacingService {


    public static void race(int carCount, int tryCount) {
        Car[] carArr = getCarArr(carCount);
        for (int i = 0; i < tryCount; i++) {
            startRace(carArr);
            ResultView.showRaceResult(carArr, i);
        }
    }

    private static void startRace(Car[] carArr) {
        for (int i = 0; i < carArr.length; i++) {
            oneCarRace(carArr, i);
        }
    }

    private static void oneCarRace(Car[] carArr, int idx) {
        Integer randomNumber = RandomNumberGenerator.getRandomNumber();
        if (RacingValidator.isMovable(randomNumber)) {
            carArr[idx].moveForward();
        }
    }

    public static Car[] getCarArr(int carCount) {
        Car[] carArr = new Car[carCount];
        for (int i = 0; i < carArr.length; i++) {
            carArr[i] = new Car(0);
        }
        return carArr;
    }

    public static void moveForward(Car car) {
        car.moveForward();
    }

}
