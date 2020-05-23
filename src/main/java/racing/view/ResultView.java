package racing.view;

public class ResultView {
    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void startPosition(int carPositions) {
        for (int i = 0; i < carPositions; i++) {
            System.out.println("-");
        }
        System.out.println();
    }

    public static void resultGame(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
