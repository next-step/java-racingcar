package step3;

public class ResultView {
    private final String RESULT_TITLE = "실행 결과";
    private final String POSITION_MARKER = "-";

    public void printTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printRoundCarPosition(int[] distances) {
        for (int distance : distances) {
            printCarDistance(distance);
        }
        System.out.println();
    }

    private void printCarDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(POSITION_MARKER);
        }
        System.out.println();
    }
}
