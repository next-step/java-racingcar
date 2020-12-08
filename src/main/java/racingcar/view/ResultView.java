package racingcar.view;

import racingcar.domain.RacingRound;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_START_MESSAGE = "*** 최종 우승자는 ";
    private static final String WINNER_END_MESSAGE = " 입니다. ***";
    private static final String RUN_MARK = "-";
    private static final String NEW_LINE = "\n";
    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ",";

    private ResultView() {
    }

    public static void displayRacingResult(List<RacingRound> racingResults) {
        StringBuilder builder = new StringBuilder();
        System.out.println(RESULT_MESSAGE);

        for (RacingRound racingRound : racingResults) {
            builder.append(printRoundResult(racingRound)).append(NEW_LINE);
        }

        System.out.println(builder.toString());
        displayWinnersResult(racingResults);
    }

    public static String printRoundResult(RacingRound racingRound) {
        StringBuilder builder = new StringBuilder();
        racingRound.getRacingCars()
                .forEach(racingCar -> builder
                        .append(makeCarResult(racingCar.getCarName(), racingCar.getCarPosition()))
                        .append(NEW_LINE));

        return builder.toString();
    }

    private static String makeCarResult(String carName, int position) {
        StringBuilder builder = new StringBuilder();
        builder.append(carName).append(SEPARATOR);
        for (int i = 0; i < position; i++) {
            builder.append(RUN_MARK);
        }
        return builder.toString();
    }

    private static void displayWinnersResult(List<RacingRound> racingResults) {
        StringBuilder builder = new StringBuilder();
        builder.append(WINNER_START_MESSAGE).append(printFinalWinners(racingResults)).append(WINNER_END_MESSAGE);
        System.out.println(builder.toString());
    }

    private static String printFinalWinners(List<RacingRound> racingResults) {
        return racingResults.get(racingResults.size() - 1)
                .getWinners()
                .stream()
                .collect(Collectors.joining(DELIMITER));
    }

}
