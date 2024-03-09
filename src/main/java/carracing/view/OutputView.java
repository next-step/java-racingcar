package carracing.view;

import carracing.model.RaceStatus;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String PRINT_GUIDE_MESSAGE = "실행 결과";

    private OutputView() {

    }

    public static void printRaceResult(List<RaceStatus> raceStatusList) {
        StringBuilder raceResultBuilder = new StringBuilder();

        String raceResult = raceStatusList.stream()
                .map(RaceStatus::hyphenExpression)
                .collect(Collectors.joining(NEXT_LINE));

        raceResultBuilder.append(PRINT_GUIDE_MESSAGE)
                .append(NEXT_LINE)
                .append(raceResult);

        System.out.print(raceResultBuilder);
    }
}
