package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingResult;

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
        StringBuffer stringBuffer = new StringBuffer();

        for (RacingResult result : results) {
            stringBuffer
                    .append(result.getName())
                    .append(" : ")
                    .append("-".repeat(result.getPosition()))
                    .append(System.lineSeparator());
        }
        System.out.println(stringBuffer.toString());
    }

    public static void printWinners(List<Car> winners) {
        StringBuffer stringBuffer = new StringBuffer();

        String winnersName = winners.stream().map(Car::getName)
                .collect(Collectors.joining(","));

        stringBuffer.append(winnersName).append("이(가) 최종 우승 했습니다.");
        System.out.println(stringBuffer.toString());
    }
}
