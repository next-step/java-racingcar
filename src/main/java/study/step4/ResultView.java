package study.step4;

import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNERS = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println(RacingConstant.NEW_LINE + RESULT_MESSAGE);
    }

    public static void printRace(Cars cars) {
        System.out.println(
                cars.stream()
                        .map(car -> car.getCarName() + RacingConstant.NAME_SPACE + StringUtils.convertIntegerToStringDash(car.getLocation()))
                        .collect(Collectors.joining(RacingConstant.NEW_LINE))
                        + RacingConstant.NEW_LINE
        );
    }

    public static void printRaceWinner(String winners) {
        System.out.println(winners + FINAL_WINNERS);
    }
}
