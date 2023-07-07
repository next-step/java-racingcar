package car.view;

import car.CarRacingGame;
import car.domain.CarsFormatter;
import car.domain.Name;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static CarsFormatter formatter = new DefaultCarsFormatter();

    public static void printWinners(CarRacingGame game) {
        System.out.println(join(game.resolveWinnerNames()) + "가 최종 우승했습니다.");
    }

    private static String join(List<Name> names) {
        return names.stream()
            .map(Name::getValue)
            .collect(Collectors.joining(", "));
    }

    public static void startPrintingResult() {
        System.out.println("\n실행 결과");
    }

    public static void printCurrentStatus(CarRacingGame game) {
        System.out.println(game.formatCurrentRaceStatus(formatter));
    }
}
