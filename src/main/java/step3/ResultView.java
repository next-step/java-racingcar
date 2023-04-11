package step3;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행 결과";

    public void newLine() {
        System.out.println();
    }

    public void printResultMessage() {
        newLine();
        System.out.println(RESULT_MESSAGE);
    }

    public void printTraceEachCar(String trace) {
        System.out.println(trace);
    }

}