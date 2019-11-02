package view;

public class ResultView {

    private static final String NEWLINE = "\n";
    private static final String INIT_DISTANCE = "";
    private static final String MOVEMENT = "-";

    public static void showResult(int[] carPositions) {
        for (int carPosition : carPositions) {
            String distance = INIT_DISTANCE;
            for (int i = 0; i < carPosition; i++) {
                distance += MOVEMENT;
            }
            System.out.println(distance);
        }
        System.out.print(NEWLINE);
    }
}
