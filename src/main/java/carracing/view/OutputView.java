package carracing.view;

import carracing.model.RaceRecord;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String NEXT_LINE = "\n";
    private static final String PRINT_GUIDE_MESSAGE = "실행 결과";

    private OutputView() {

    }

    public static void printRaceResult(List<RaceRecord> raceRecordList) {
        StringBuilder raceResultBuilder = new StringBuilder();

        raceResultBuilder.append(PRINT_GUIDE_MESSAGE)
                .append(NEXT_LINE)
                .append(raceResult(raceRecordList));

        System.out.print(raceResultBuilder);
    }

    private static String raceResult(List<RaceRecord> raceRecordList) {
        StringJoiner raceResultJoiner = new StringJoiner(NEXT_LINE);

        for (RaceRecord raceRecord : raceRecordList) {
            raceResultJoiner.add(hyphenExpression(raceRecord));
        }

        return raceResultJoiner.toString();
    }

    private static String hyphenExpression(RaceRecord raceRecord) {
        StringBuilder hyphenExpressionBuilder = new StringBuilder();

        String defaultHyphenExpression = raceRecord.positionOfCarList().stream()
                .map(HYPHEN::repeat)
                .collect(Collectors.joining(NEXT_LINE));

        hyphenExpressionBuilder.append(defaultHyphenExpression);

        if (!raceRecord.isLastAttempt()) {
            hyphenExpressionBuilder.append(NEXT_LINE);
        }

        return hyphenExpressionBuilder.toString();
    }
}
