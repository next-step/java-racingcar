package racing;

import java.util.List;

public class ResultView {
    public static void printCars(List<RacingCar> racingCars) {
        for(RacingCar racingCar : racingCars) {
            System.out.println(racingCar.toString());
        }
    }
}
