package racing.view;

import racing.domain.Car;
import racing.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printCarsLocation(final RacingGame racingGame) {
        System.out.println(racingGame.toStringForPrintLocation() + "\n");
    }

    public static void printRacingWinners(List<Car> racingWinners) {
        System.out.print("최종 우승자 : ");
        String winners = racingWinners.stream().map(Car::toString).collect(Collectors.joining(", "));
        System.out.println(winners);
    }
}
