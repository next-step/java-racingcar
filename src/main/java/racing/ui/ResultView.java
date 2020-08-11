package racing.ui;

public class ResultView {

    private static final String NEW_LINE = "\n";
    private String board = "";

    public void trace(String route) {
        board += (route + NEW_LINE);
    }

    public void nextTrial() {
        board += NEW_LINE;
    }

    public void printResult() {
        System.out.println(board);
    }
}
