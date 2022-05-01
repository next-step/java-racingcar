package racingcar.module;

import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.RacingCar;
import racingcar.domain.Winners;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_PHRASE = "가 최종 우승했습니다.";

    public static void printResult(Race race) {
        printResultMessage();

        List<String> results = race.getRaceResults();

        for (String raceResult : results) {
            System.out.println(raceResult);
        }

        printWinners(Winners.findWinners(race.getRacingCars()));
    }

    private static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinners(List<RacingCar> winners) {
        String message = "";
        for (RacingCar winner: winners) {
            message = message + winner.getName() + ", ";
        }
        message = message.substring(0, message.length() - 2) + WINNER_PHRASE;

        System.out.println(message);
    }
}
