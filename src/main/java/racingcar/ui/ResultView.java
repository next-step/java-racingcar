package racingcar.ui;

import racingcar.Car;

import java.util.List;

public class ResultView {
    private static final String PATH_STRING = "-";

    private static final String ROUND_RESULT_FORMAT = "%s : %s";

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
}
