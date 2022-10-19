package racingCar.util;

import racingCar.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarUtil {

    public static String[] inputNameToCarNames(String inputName) {
        return inputName.split(",");
    }

    private static void addWinner(List<String> winners, RacingCar racingCar, int winnerDistance) {

        if (racingCar.distance() == winnerDistance) {
            winners.add(racingCar.name());
        }
    }

    public static int maxDistance(List<RacingCar> racingCars) {

        int winnerDistance = 0;

        for (RacingCar racingCar : racingCars) {
            winnerDistance = racingCar.distance() > winnerDistance ? racingCar.distance() : winnerDistance;
        }

        return winnerDistance;
    }

    public static List<String> maxDistanceWinners(List<RacingCar> racingCars) {

        List<String> winners = new ArrayList<>();
        int winnerDistance = maxDistance(racingCars);

        for (RacingCar racingCar : racingCars) {
            addWinner(winners, racingCar, winnerDistance);
        }

        return winners;
    }

    public static String winnersToString(List<String> winners) {

        String winnersStr = "";

        for (String winner : winners) {
            winnersStr += winner + ", ";
        }

        return winnersStr.substring(0, winnersStr.length() - 2);
    }
}
