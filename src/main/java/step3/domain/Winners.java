package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<RacingCar> getWinners(RacingCar[] racingCars) {
        return getAllWinners(racingCars, getFastest(racingCars));
    }

    public static List<CarName> getWinnerNames(RacingCar[] racingCars) {
        List<CarName> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : getWinners(racingCars)) {
            winnerNames.add(racingCar.name());
        }
        return winnerNames;
    }

    private static RacingCar getFastest(RacingCar[] racingCars) {
        RacingCar faster = racingCars[0];
        for (int index = 1; index < racingCars.length; index++) {
            faster = faster.getFaster(racingCars[index]);
        }
        return faster;
    }

    private static List<RacingCar> getAllWinners(RacingCar[] racingCars, RacingCar fastest) {
        List<RacingCar> winnerList = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            addWinner(winnerList, fastest, racingCar);
        }

        return winnerList;
    }

    private static void addWinner(List<RacingCar> winnerList, RacingCar faster, RacingCar racingCar) {
        if (racingCar.matchDistance(faster))
            winnerList.add(racingCar);
    }

}
