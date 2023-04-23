package racing.view;

import racing.domain.Car;
import racing.domain.RacingResult;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class ResultView {

    public static void printGameResult(RacingResult racingResult) {
        System.out.println("자동차 경주 결과 입니다.");
        printCarsLocation(racingResult);
        System.out.println("경주 종료.");
    }

    private static void printCarsLocation(RacingResult racingResult) {
        racingResult.carList().forEach(ResultView::printCarLocation);
    }

    private static void printCarLocation(Car car) {
        int location = location(car);
        if (onStartLine(location)) {
            printBlankLine();
            return;
        }
        printCarLocation(location);
    }

    private static int location(Car car) {
        return car.location();
    }

    private static boolean onStartLine(int location) {
        return location == 0;
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static void printCarLocation(int location) {
        System.out.println("-".repeat(location));
    }
}
