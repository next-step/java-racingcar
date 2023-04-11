package racing.view;

import racing.domain.RacingCar;
import racing.domain.RacingGame;

public class ResultView {
    private static final char PRINT_POSITION_CHAR = '-';

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printGameStatus(RacingGame game) {
        for (RacingCar racingCar : game.getGameCars()) {
            printCarStatus(racingCar);
        }
        System.out.println();
    }

    public static void printCarStatus(RacingCar car) {
        printOngoingStatus(car.getPosition());
    }

    private static void printOngoingStatus(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(PRINT_POSITION_CHAR);
        }
        System.out.println();
    }
}
