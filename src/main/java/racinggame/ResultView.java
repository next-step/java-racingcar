package racinggame;

import java.util.List;

public class ResultView {
    public static final String LOCATION_VIEW = "-";

    public static void gameResultStart() {
        System.out.println("실행결과");
    }
    public static void gameResultView(List<Car> cars) {
        for (Car car : cars) {
            showLocation(car);
        }
    }

    private static void showLocation(Car car) {
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(LOCATION_VIEW);
        }
        System.out.println();
    }

}
