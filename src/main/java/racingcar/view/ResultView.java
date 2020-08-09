package racingcar.view;

import racingcar.domain.RacingRound;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RUN_MARK = "-";
    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ",";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_START_MESSAGE = "*** 최종 우승자는 ";
    private static final String WINNER_END_MESSAGE = " 입니다. ***";
    private static final String ROUND_START_MESSAGE = "[ROUND ";
    private static final String ROUND_END_MESSAGE = "]";

    private static List<RacingRound> racingResults;

    public ResultView(List<RacingRound> racingResults) {
        this.racingResults = racingResults;
    }

    public void displayRacingResult() {
        StringBuilder builder = new StringBuilder();
        int round = 1;
        System.out.println(RESULT_MESSAGE);

        for (RacingRound racingRound : racingResults) {
            builder.append(ROUND_START_MESSAGE).append(round++).append(ROUND_END_MESSAGE).append("\n");
            builder.append(printRoundResult(racingRound)).append("\n");
        }
        System.out.print(builder.toString());
    }

    public void displayWinnersResult() {
        StringBuilder builder = new StringBuilder();
        builder.append(WINNER_START_MESSAGE).append(printFinalWinners()).append(WINNER_END_MESSAGE);
        System.out.println(builder.toString());
    }

    public String printRoundResult(RacingRound racingRound) {
        StringBuilder builder = new StringBuilder();
        racingRound.getRacingCars()
                .forEach(racingCar -> builder
                        .append(makeCarPosition(racingCar.getCarName(), racingCar.getCarPosition()))
                        .append("\n")
                );
        return builder.toString();
    }

    private String makeCarPosition(String carName, int position) {
        StringBuilder builder = new StringBuilder();
        builder.append(carName).append(SEPARATOR);
        for (int i = 0; i < position; i++) {
            builder.append(RUN_MARK);
        }
        return builder.toString();
    }

    private String printFinalWinners() {
        return racingResults.get(racingResults.size() - 1)
                .getWinners()
                .stream()
                .collect(Collectors.joining(DELIMITER));
    }

}
