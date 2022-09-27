package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static String getLocationStrings(List<RacingCar> racingCars) {
        return racingCars.stream()
                         .map(ResultView::getLocationString)
                         .collect(Collectors.joining("\n"));
    }

    private static String getLocationString(RacingCar racingCar) {
        return "-".repeat(racingCar.getDistance());
    }

    public static void printRacingGameLogs(List<String> racingGameLogs) {
        System.out.println("실행 결과\n" + String.join("\n\n", racingGameLogs));
    }
}
