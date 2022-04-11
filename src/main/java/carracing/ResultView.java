package carracing;

import java.util.List;

public class ResultView {
    private static final String ROUTE = "-";

    private ResultView() {}

    public static String makeRacingCarRoute(RacingCar car) {
        StringBuilder stringBuilder = new StringBuilder();
        int position = car.getPosition();
        while(position-- > 0) {
            stringBuilder.append(ROUTE);
        }
        return stringBuilder.toString();
    }

    public static void printRacingCarsRoutes(List<RacingCar> carList) {
        carList.forEach(car -> System.out.println(makeRacingCarRoute(car)));
    }
}
