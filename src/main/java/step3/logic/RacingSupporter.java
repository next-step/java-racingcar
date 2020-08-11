package step3.logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingSupporter {

    public static String[] getTeamReady(String racingTeams) {
        return racingTeams.split(",");
    }

    public static List<Car> setCarsForRacing(String[] teamNames) {
        List<Car> cars = Arrays.stream(teamNames)
                .filter(name -> name.length() < 5)
                .map(Car::new)
                .collect(Collectors.toList());

        return cars;
    }
}
