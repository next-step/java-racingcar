package javaracingcarwinner.util;

import javaracingcarwinner.entity.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingUtil {

    public static List<RacingCar> whoIsWinners(List<RacingCar> cars) {
        final List<RacingCar> winners = new ArrayList<>();
        int maximumLocation = 0;

        for (RacingCar car : cars) {
            int location = car.location();
            if (maximumLocation < location) {
                maximumLocation = location;
            }
        }

        for (RacingCar car : cars) {
            if (car.location() == maximumLocation) {
                winners.add(car);
            }
        }

        return winners;
    }

}
