package step3.logic;

import java.util.*;
import java.util.stream.Collectors;

public class RacingSupporter {

    public static String[] getTeamReady(String racingTeams) {
        return racingTeams.split(",");
    }

    public static List<Car> setCarsForRacing(String[] teamNames) {

        return Arrays.stream(teamNames)
                .filter(name -> name.length() < 5)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static void getWinners(List<Car> cars) {
        List<Car> winners = cars.stream()
                .collect(Collectors.groupingBy(
                        Car::getCarMovedCount,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .lastEntry()
                .getValue();

        winners.forEach(car -> System.out.println(car.getCarName()));
    }
}
