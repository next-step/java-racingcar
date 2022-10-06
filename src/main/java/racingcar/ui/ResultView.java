package racingcar.ui;

import racingcar.Car;

import java.util.List;

public class ResultView {
    private static final String PATH_STRING = "-";

    private static final String ROUND_RESULT_FORMAT = "%s : %s";

    private static final String WINNER_RESULT_FORMAT = "%s가 최종 우승했습니다.";

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> roundResult) {
        roundResult.forEach(car -> System.out.println(getRoundResultStr(car.getName(), car.getPosition())));

        System.out.println();
    }

    public static String getRoundResultStr(String name,int position) {
        return String.format(ROUND_RESULT_FORMAT, name, getPathString(position));
    }

    public static String getPathString(Integer position) {
        return PATH_STRING.repeat(position);
    }

    public static void printWinnerMessage(List<String> winnerName) {
        System.out.println(getWinnerMessage(winnerName));
    }

    public static String getWinnerMessage(List<String> winnerName) {
        String namesComma = String.join(", ", winnerName);
        return String.format(WINNER_RESULT_FORMAT, namesComma);
    }
}
