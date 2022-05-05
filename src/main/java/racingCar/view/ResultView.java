package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.RandomNumber;
import racingCar.domain.Winners;

public class ResultView {
    public static void resultOfCars(Cars cars, int carOfNumber) {
        for (int i = 0; i < carOfNumber; i++) {
            System.out.println(cars.carMakeNameAndPosition(i));
            int temporaryRandomNumber = RandomNumber.createRandomNumber();
            cars.carMove(i, temporaryRandomNumber);
        }
        System.out.println("");
    }

    public static void resultOfWinners(Cars cars) {
        Winners winners = cars.findWinners();
        System.out.println(winners.winnersNameList() + "가 최종 우승했습니다.");
    }


}
