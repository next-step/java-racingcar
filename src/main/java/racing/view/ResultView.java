package racing.view;

public class ResultView {
    public static void startPosition(int carPositions) {
        for (int i = 0; i < carPositions; i++) {
            System.out.println("-");
        }
        System.out.println();
    }

}
