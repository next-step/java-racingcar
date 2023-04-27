package racing.view;

import racing.domain.Cars;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class ResultView {
    private static final String PRINT_CAR_FORMAT = "%s\t:\t%s\n";
    private static final String PRINT_WINNERS_FORMAT = "%s가 최종 우승했습니다.";

    public static void printGameStart() {
        System.out.println("실행 결과");
    }

    public static void printCars(Cars cars) {
        cars.deepCopyCarList()
                .forEach(car -> System.out.printf(PRINT_CAR_FORMAT, car.name(), "-".repeat(car.position())));
        System.out.println();
    }

    public static void printWinners(Cars cars) {
        System.out.printf(PRINT_WINNERS_FORMAT, cars.winnerNames());
    }
}
