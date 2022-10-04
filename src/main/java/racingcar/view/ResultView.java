package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static String getLocationStrings(List<RacingCar> racingCars) {
        return racingCars.stream()
                         .map(ResultView::getLocationString)
                         .collect(Collectors.joining("\n"));
    }

    private static String getLocationString(RacingCar racingCar) {
        return String.format("%s : %s", racingCar.getName(), "-".repeat(racingCar.getDistance()));
    }

    public static void printRacingGameLogs(List<String> racingGameLogs) {
        System.out.println("\n실행 결과\n" + String.join("\n\n", racingGameLogs));
    }

    public static String getWinnerString(List<RacingCar> winners) {
        return String.format("%s가 최종 우승했습니다.", joinRacingCarNames(winners));
    }

    private static String joinRacingCarNames(List<RacingCar> winners) {
        return winners.stream()
                      .map(RacingCar::getName)
                      .collect(Collectors.joining(", "));
    }
}
