package race.view;

import race.domain.Car;
import race.domain.Cars;
import race.domain.Winners;
import race.util.RandomNumberUtil;

public class ResultView {

    public static void printResult(Cars cars, int numberOfTry) {
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfTry; i++) {
            printCarPosition(cars);
            System.out.println();
        }

        Winners winners = new Winners();
        winners.findWinners(cars);

        System.out.println("최종 우승 : " + winners.getWinners());
    }


    private static void printCarPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(RandomNumberUtil.getRandomNumber());
            cars.setMaxPosition(car.getPosition());
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
