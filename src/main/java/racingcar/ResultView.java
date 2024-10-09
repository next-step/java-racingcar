package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE = "-".repeat(5);

    private ResultView() {

    }

    public static void roundStart(int roundNumber) {
        System.out.println(LINE + roundNumber + " 라운드 시작!" + LINE);
    }

    public static void drawCarPositions(List<RacingResult> results) {
        for (RacingResult result : results) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append(result.getName())
                    .append(" : ")
                    .append("-".repeat(result.getPosition()));
            System.out.println(stringBuilder.toString());
        }
    }

    public static void printWinners(List<Car> winners) {
        String winnersName = winners.stream().map(Car::getName)
                .collect(Collectors.joining(","));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(winnersName)
                .append("이(가) 최종 우승 했습니다.");
        System.out.println(stringBuilder.toString());
    }
}
