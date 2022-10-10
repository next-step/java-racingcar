package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameLog;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printRacingGameResult(RacingGame racingGame) {
        System.out.println("\n실행 결과");
        System.out.println(racingGame.getGameLogs()
                                     .stream()
                                     .map(ResultView::getLogString)
                                     .collect(Collectors.joining("\n\n")));
        System.out.println("\n" + getWinnerString(racingGame.getWinners()));
    }

    private static String getLocationString(RacingCar racingCar) {
        return String.format("%s : %s", racingCar.getName(), "-".repeat(racingCar.getDistance()));
    }

    private static String getLogString(RacingGameLog racingGameLog) {
        return racingGameLog.getRacingCars()
                            .getRacingCars()
                            .stream()
                            .map(ResultView::getLocationString)
                            .collect(Collectors.joining("\n"));
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
