package carracing;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEXT_LINE = "\n";

    private OutputView() {

    }

    public static void printRaceResult(List<RaceStatus> raceStatusList) {
        System.out.println("실행 결과");

        String raceResult = raceStatusList.stream()
                .map(RaceStatus::hyphenExpression)
                .collect(Collectors.joining(NEXT_LINE));
        System.out.print(raceResult);
    }
}
