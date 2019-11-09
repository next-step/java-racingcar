package winner.view;

import winner.domain.Car;
import winner.domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:22
 */
public class CarRaceResultView {

    public static void printCars(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getCurrentPositionText()));
        printBlankLine();
    }

    public static void printBlankLine() {
        System.out.println();
    }

    public static void printWinner(String winners) {
        System.out.println(String.format("%s가 최종 우승했습니다.", winners));
    }
}
