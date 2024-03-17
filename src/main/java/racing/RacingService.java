package racing;

import util.RacingValidator;

public class RacingService {


    public static void race(int carCount, int tryCount) {
        Car[] carArr = getCarArr(carCount);
    }

    public static Car[] getCarArr(int carCount) {
        Car[] carArr = new Car[carCount];
        for (int i = 0; i < carArr.length; i++) {
            carArr[i] = new Car(0);
        }
        return carArr;
    }

    public boolean checkMovable(int randomNumber) {
        return RacingValidator.isMovable(randomNumber);
    }

    public static void moveForward(Car car) {
        car.moveForward();
    }

}
