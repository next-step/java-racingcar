package racingcar.ui;

import java.util.List;

public class ResultView {
    private static final String PATH_STRING = "-";

    public static void printResultStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Integer> roundResult) {
        roundResult.stream()
                .forEach(position -> System.out.println(getPathString(position)));

        System.out.println();
    }

    public static String getPathString(Integer position) {
        return PATH_STRING.repeat(position);
    }
}
