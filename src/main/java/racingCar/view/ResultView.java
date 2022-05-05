package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.RandomNumber;
import racingCar.domain.Winners;

public class ResultView {
    public static void resultOfCars(Cars cars, int carOfNumber) {
        System.out.println(cars.carMakeNameAndPosition(0));
        for (int i = 1; i < carOfNumber; i++) {
            int temporaryRandomNumber = RandomNumber.createRandomNumber();
            cars.carMove(i, temporaryRandomNumber);
            System.out.println(cars.carMakeNameAndPosition(i));
        }
        System.out.println("");
    }

    public static void resultOfWinners(Cars cars) {
        Winners winners = cars.findWinners();
        System.out.println(winners.winnersNameList() + "가 최종 우승했습니다.");
    }


}
