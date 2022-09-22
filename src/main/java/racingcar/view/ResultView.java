package racingcar.view;

public class ResultView {

    private static final String RESULT_MESSAGE = "\n실행 결과";

    private ResultView() {
    }

    public static void printResult(RacingGameResult result) {
        System.out.println(RESULT_MESSAGE);
        result.records()
                .forEach(System.out::println);
        System.out.println(result.getWinMessage());
    }
}
