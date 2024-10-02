package javaracingcarwinner.util;

import javaracingcarwinner.entity.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingUtil {

    public static List<RacingCar> whoIsWinners(List<RacingCar> cars) {
        final List<RacingCar> winners = new ArrayList<>();

        final int winnerLocation = winnerLocation(cars);

        for (RacingCar car : cars) {
            addWinner(winners, winnerLocation, car);
        }

        return winners;
    }

    private static void addWinner(List<RacingCar> winners, int winnerLocation, RacingCar car) {
        if (isWinner(winnerLocation, car.location())) {
            winners.add(car);
        }
    }

    private static boolean isWinner(int winnerLocation, int location) {
        return winnerLocation == location;
    }

    private static int winnerLocation(List<RacingCar> cars) {
        int maximumLocation = 0;

        for (RacingCar car : cars) {
            maximumLocation = updateWinnerLocation(maximumLocation, car.location());
        }

        return maximumLocation;
    }

    private static int updateWinnerLocation(int maximumLocation, int location) {
        if (maximumLocation < location) {
            return location;
        }
        return maximumLocation;
    }

}
