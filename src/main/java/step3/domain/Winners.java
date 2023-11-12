package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<RacingCar> getWinners(RacingCar[] racingCars) {
        int maxDistance = getMaxDistance(racingCars);

        List<RacingCar> racingCarList = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            addWinner(maxDistance, racingCarList, racingCar);
        }

        return racingCarList;
    }

    private static void addWinner(int maxDistance, List<RacingCar> racingCarList, RacingCar racingCar) {
        if (racingCar.getDistance() != maxDistance) return;
        racingCarList.add(racingCar);
    }

    private static int getMaxDistance(RacingCar[] racingCars) {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCars) {
            maxDistance = getMax(maxDistance, racingCar.getDistance());
        }
        return maxDistance;
    }

    private static int getMax(int max, int distance) {
        if (distance > max) return distance;
        return max;
    }

    public static String getWinnerNames(RacingCar[] racingCars) {
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : getWinners(racingCars)) {
            winnerNames.add(racingCar.getName());
        }
        return String.join(", ", winnerNames);
    }

}
