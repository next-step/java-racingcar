package racing.view;

import racing.domain.Name;
import racing.domain.Position;
import racing.domain.RacingCar;
import racing.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

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
        printName(car.name());
        printOngoingStatus(car.position());
        System.out.println();
    }

    private static void printOngoingStatus(Position position) {
        for (int i = 0; i < position.getPosition(); i++) {
            System.out.print(PRINT_POSITION_CHAR);
        }
    }

    private static void printName(Name name) {
        System.out.print(name + " : ");
    }

    public static void printWinner(RacingGame game) {
        List<String> winnerNames = game.getWinnerNames()
                .stream()
                .map(Name::toString)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }
}
