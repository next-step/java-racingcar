package racingcar.service;

import racingcar.domain.Car;

public class CarService {

    private static final int GO_MAX = 9;
    private static final int GO_MIN = 4;

    private CarService() {

    }

    private static boolean isGoRange(int randomNumber) {
        return randomNumber >= GO_MIN && randomNumber <= GO_MAX;
    }

    public static void move(Car car) {
        int randomNumber = RandomNumberService.getRandomNumber();
        if(isGoRange(randomNumber)) car.go();
    }

}
