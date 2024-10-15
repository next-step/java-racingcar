package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final StringBuilder BUILDER = new StringBuilder();
    private static final String LINE = "-".repeat(5);

    private ResultView() {

    }

    public static void roundStart(int roundNumber) {
        System.out.println(LINE + roundNumber + " 라운드 시작!" + LINE);
    }

    public static void drawCarPositions(List<RacingResult> results) {
        for (RacingResult result : results) {
            BUILDER
                    .append(result.getName())
                    .append(" : ")
                    .append("-".repeat(result.getPosition()))
                    .append("\n");
        }
        System.out.println(BUILDER.toString());
        BUILDER.setLength(0);
    }

    public static void printWinners(List<Car> winners) {
        String winnersName = winners.stream().map(Car::getName)
                .collect(Collectors.joining(","));

        BUILDER.append(winnersName).append("이(가) 최종 우승 했습니다.");
        System.out.println(BUILDER.toString());
        BUILDER.setLength(0);
    }
}
