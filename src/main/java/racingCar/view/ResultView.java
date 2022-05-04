package racingCar.view;

import racingCar.domain.Cars;
import racingCar.domain.RandomNumber;
import racingCar.domain.Winners;

public class ResultView {
    public static void resultOfCars(Cars cars) {
        RandomNumber randomNumber = new RandomNumber();
        for (int i = 0; i < cars.carsSize(); i++) {
            System.out.println(cars.carMakeNameAndPosition(i));
            int temporaryRandomNumber = randomNumber.createRandomNumber();
            cars.carMove(i, temporaryRandomNumber);
        }
        System.out.println("");
    }

    public static void resultOfWinners(Cars cars) {
        Winners winners = cars.findWinners();
        System.out.println(winners.winnersNameList() + "가 최종 우승했습니다.");
    }

}
