package step3;

public class ResultView {
    public static final String LOCATION_VIEW = "-";

    public static void gameResultView(int currentLocation) {
        for (int i = 0; i < currentLocation; i++) {
            System.out.print(LOCATION_VIEW);
        }
        System.out.println();
    }

}
