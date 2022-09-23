package step3;

import java.util.Random;

public class RacingSupport {

    static Car[] prepareCar(Car[] cars){
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        return cars;
    }

    static void race(Car[] preparedCar, Integer tryCount) {
        RacingCarOutput.printResultStartMessage();
        for (int i = 0; i < tryCount; i++) {
            raceEachCar(preparedCar);
        }
    }

    private static void raceEachCar(Car[] preparedCar) {
        for (int j = 0; j < preparedCar.length; j++) {
            moveByRandom(isRandomGreaterThanThree(), preparedCar, j);
        }
        RacingCarOutput.printDividingLine();
    }

    private static void moveByRandom(Boolean isMove, Car[] preparedCars, Integer j) {
        if (isMove) {
            preparedCars[j].moveForward();
            RacingCarOutput.printRacingResult(preparedCars[j]);
            return;
        }

        RacingCarOutput.printRacingResult(preparedCars[j]);
    }

    private static Boolean isRandomGreaterThanThree(){
        int random = new Random().nextInt(10);
        if (random > 3) {
            return true;
        }

        return false;
    }
}
