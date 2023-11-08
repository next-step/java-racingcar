package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Round;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_POSITION_MODEL = "-";

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRacingResults(final List<Round> rounds) {
        for (Round round : rounds) {
            printRoundResults(round);
            System.out.println();
        }
    }

    private void printRoundResults(Round round) {
        round.getRoundCarStatus().getCars().forEach(car -> {
            printCurrentCarPosition(car);
        });
    }

    private void printCurrentCarPosition(final Car car) {
        System.out.println(buildCarPosition(car.getCarPosition()));
    }

    private String buildCarPosition(final int carPosition) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            result.append(CAR_POSITION_MODEL);
        }
        return result.toString();
    }

}
