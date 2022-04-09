package carracing;

import java.util.List;

public class ResultView {
    public static void printRacingResult(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).route.toString());
        }
    }
}
