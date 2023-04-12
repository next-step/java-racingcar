package racing.view;

import racing.domain.RacingCar;
import racing.domain.RacingGame;

import java.util.ArrayList;
import java.util.List;

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
        printCarName(car);
        printOngoingStatus(car.getPosition());
        System.out.println();
    }

    private static void printOngoingStatus(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(PRINT_POSITION_CHAR);
        }
    }

    private static void printCarName(RacingCar car) {
        System.out.print(car.getName() + " : ");
    }

    public static void printWinner(RacingGame game) {
        List<RacingCar> winners = game.findWinner();
        System.out.print(String.join(", ", findWinnerNames(winners)));
        System.out.println("가 최종 우승했습니다.");
    }

    private static List<String> findWinnerNames(List<RacingCar> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }
        return winnerNames;
    }
}
