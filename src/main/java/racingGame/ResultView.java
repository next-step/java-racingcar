package racingGame;

import java.util.List;

public class ResultView {

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    private static void printCar(Car car) {
        System.out.println(new String(new char[car.getCurrentPosition()])
            .replace("\0", "-"));
    }

}
