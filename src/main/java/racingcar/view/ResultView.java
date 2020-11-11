package racingcar.view;

import racingcar.dto.RaceResultValue;
import racingcar.dto.StepByCar;
import racingcar.dto.StepResult;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private static final String REGEX_COMMA = ",";
    private static final String MOVE_DASH = "-";
    private static final String RACE_TREM = "********************";
    private static final String OUTPUT_FORMAT_WINNER = "%s가 최종 우승했습니다.";
    private static final String OUTPUT_FORMAT_RACE_TERM_RESULT = "%s : %s";

    public static void output(OuputChannel outputChnnel, RaceResultValue raceResultValue) {
        outputByStep(outputChnnel, raceResultValue);
        winner(outputChnnel, raceResultValue);
    }

    public static void outputByStep(OuputChannel outputChnnel, RaceResultValue raceResultValue) {
        for (StepResult stepResult : raceResultValue.getStepResults()) {
            outputByStep(outputChnnel, stepResult);
        }

    }

    public static void outputByStep(OuputChannel outputChnnel, StepResult stepResult) {
        for (StepByCar stepByCar : stepResult.getStepByCar()) {
            outputChnnel.out(parseResult(stepByCar));
        }
        outputChnnel.out(RACE_TREM);
    }

    public static String parseResult(StepByCar stepByCar) {
        return String.format(OUTPUT_FORMAT_RACE_TERM_RESULT,
                             stepByCar.getName(), getMoveDash(stepByCar.getPosition()));
    }

    public static String getMoveDash(int position) {
        return Stream.generate(() -> MOVE_DASH)
                .limit(position)
                .collect(joining());
    }

    public static void winner(OuputChannel outputChnnel, RaceResultValue raceResultValue) {
        String winnerName = String.join(REGEX_COMMA, raceResultValue.getFinalWinnerName());

        String winner = String.format(OUTPUT_FORMAT_WINNER, winnerName);
        outputChnnel.out(winner);
    }
}
