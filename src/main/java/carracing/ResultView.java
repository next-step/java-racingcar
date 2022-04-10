package carracing;

import java.util.List;

public class ResultView {
    public static final String ROUTE = "-";

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
        for (int i = 0; i < carList.size(); i++){
            System.out.println(makeRacingCarRoute(carList.get(i)));
        }
    }
}
