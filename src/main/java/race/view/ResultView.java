package race.view;

import race.domain.Car;
import race.domain.Cars;
import race.util.RandomNumberUtil;

public class ResultView {

    public static void printResult(Cars cars, int numberOfTry) {
        System.out.println("실행 결과");

        for (int i = 0; i < numberOfTry; i++) {
            printCarPosition(cars);
            System.out.println();
        }
    }

    private static void printCarPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(RandomNumberUtil.getRandomNumber());
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
