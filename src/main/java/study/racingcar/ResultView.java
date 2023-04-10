package study.racingcar;

public class ResultView {

    private static String RESULT_MESSAGE = "위치 : ";
    public static void resultGame(String position) {
        System.out.println(RESULT_MESSAGE + position);
    }

    public static void emptyLine() {
        System.out.println();
    }
}
