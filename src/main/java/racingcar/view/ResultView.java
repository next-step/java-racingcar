package racingcar.view;

import racingcar.domain.RacingRound;

import java.util.List;


public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RUN_MARK = "-";
    private static final String NEW_LINE = "\n";

    private ResultView() {
    }

    public static void displayRacing(List<RacingRound> racingResults) {
        StringBuilder builder = new StringBuilder();
        System.out.println(RESULT_MESSAGE);

        for (RacingRound racingRound : racingResults) {
            builder.append(printRoundResult(racingRound)).append(NEW_LINE);
        }

        System.out.println(builder.toString());
    }

    public static String printRoundResult(RacingRound racingRound) {
        StringBuilder builder = new StringBuilder();
        racingRound.getRacingCars()
                .forEach(racingCar -> builder
                        .append(makeCarResult(racingCar.getCarPosition()))
                        .append(NEW_LINE));

        return builder.toString();
    }

    public static String makeCarResult(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(RUN_MARK);
        }
        return builder.toString();
    }

}
