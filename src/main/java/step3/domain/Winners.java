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
        if (!racingCar.matchDistance(maxDistance)) return;
        racingCarList.add(racingCar);
    }

    private static int getMaxDistance(RacingCar[] racingCars) {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCars) {
            maxDistance = racingCar.getMaxDistance(maxDistance);
        }
        return maxDistance;
    }

    public static List<CarName> getWinnerNames(RacingCar[] racingCars) {
        List<CarName> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : getWinners(racingCars)) {
            winnerNames.add(racingCar.name());
        }
        return winnerNames;
    }

}
