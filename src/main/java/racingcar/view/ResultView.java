package racingcar.view;

public class ResultView {
    private static final String VIEW = "-";

    public static void nextLine() {
        System.out.println();
    }

    public static void printResultView(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.printf(VIEW);
        }
    }
}
