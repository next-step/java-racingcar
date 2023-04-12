package step3;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public static void newLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

}