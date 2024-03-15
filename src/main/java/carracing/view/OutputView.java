package carracing.view;

import carracing.domain.NumberOfAttempts;
import carracing.domain.car.RaceRecordOfCar;
import carracing.domain.race.RaceResult;

import java.util.List;

public class OutputView {
    private static final String COLON_BETWEEN_SPACE = " : ";
    private static final String HYPHEN = "-";
    private static final String NEXT_LINE = "\n";
    private static final String PRINT_GUIDE_MESSAGE = "실행 결과";
    private static final String RACE_WINNER_MESSAGE = "가 최종 우승했습니다";

    private OutputView() {

    }

    public static void printRaceResult(final NumberOfAttempts numberOfAttempts, final RaceResult raceResult) {
        StringBuilder raceResultBuilder = new StringBuilder();

        raceResultBuilder.append(NEXT_LINE)
                .append(PRINT_GUIDE_MESSAGE)
                .append(NEXT_LINE)
                .append(raceResult(numberOfAttempts, raceResult.recordOfCarList()))
                .append(raceWinner(raceResult.winner()));

        System.out.print(raceResultBuilder);
    }

    private static String raceResult(final NumberOfAttempts numberOfAttempts, final List<RaceRecordOfCar> raceRecordOfCarList) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int attempt = 0; attempt < numberOfAttempts.numberOfAttempts(); attempt++) {
            resultBuilder.append(hyphenExpressionByAttempt(attempt, raceRecordOfCarList))
                    .append(NEXT_LINE);
        }

        return resultBuilder.toString();
    }

    private static String hyphenExpressionByAttempt(final int attempt, final List<RaceRecordOfCar> raceRecordOfCarList) {
        StringBuilder hyphenExpressionBuilder = new StringBuilder();

        raceRecordOfCarList.forEach(raceRecordOfCar -> hyphenExpressionBuilder.append(raceRecordOfCar.carName())
                .append(COLON_BETWEEN_SPACE)
                .append(HYPHEN.repeat(raceRecordOfCar.positionByAttempt(attempt)))
                .append(NEXT_LINE)
        );

        return hyphenExpressionBuilder.toString();
    }

    private static String raceWinner(final String winner) {
        return new StringBuilder()
                .append(winner)
                .append(RACE_WINNER_MESSAGE)
                .toString();
    }
}
