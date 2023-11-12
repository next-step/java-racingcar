package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    RacingCar[] racingCars;

    public Winners(RacingCar[] racingCars) {
        this.racingCars = racingCars;
    }

    public static List<RacingCar> getWinners(RacingCar[] racingCars) {
        int max = 0;
        for (RacingCar racingCar : racingCars) {
            int distance = racingCar.getDistance();
            if (distance > max)
                max = distance;
        }

        List<RacingCar> racingCarList = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getDistance() == max) {
                racingCarList.add(racingCar);
            }
        }

        return racingCarList;
    }

    public static String getWinnerNames(RacingCar[] racingCars) {
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : getWinners(racingCars)) {
            winnerNames.add(racingCar.getName());
        }
        return String.join(", ", winnerNames);
    }

}
