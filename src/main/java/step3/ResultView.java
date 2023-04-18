package step3;

public class ResultView {
    public static final String LOCATION_VIEW = "-";

    public static void gameResultView(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(LOCATION_VIEW);
        }
        System.out.println();
    }

}
