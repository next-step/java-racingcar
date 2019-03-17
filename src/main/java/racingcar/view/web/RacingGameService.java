package racingcar.view.web;

import java.util.Arrays;
import racingcar.domain.Race;
import racingcar.domain.RacingCar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameService {
    public static Map<String, Object> getNames(final String[] names) {
        List<String> carNames = Arrays.asList(names);

        Map<String, Object> result = new HashMap<>();

        result.put("cars", carNames);

        return result;
    }

    public static Map<String, Object> startGame(final String[] carNames, final int turn)
        throws CloneNotSupportedException {

        Race race = new Race(carNames);
        List<RaceResult> carsByRaces = new ArrayList<>();

        for (int i = 1; i <= turn; i++) {
            RaceResult raceResult = new RaceResult("Race " + i, copyCars(race.play()));

            carsByRaces.add(raceResult);
        }

        Map<String, Object> gameResult = new HashMap<>();

        gameResult.put("carsByRaces", carsByRaces);
        gameResult.put("winnerNames", getWinnerNames(race));

        return gameResult;
    }

    private static String getWinnerNames(Race race) {
        List<RacingCar> winners = race.getWinners();
        List<String> winnerNames = new ArrayList<>();

        for (RacingCar winner : winners) {
            winnerNames.add(winner.getName());
        }

        return String.join(", ", winnerNames);
    }

    private static List<RacingCar> copyCars(List<RacingCar> cars)
        throws CloneNotSupportedException {

        List<RacingCar> copyCars = new ArrayList<>(cars.size());

        for (RacingCar car : cars) {
            copyCars.add((RacingCar) car.clone());
        }

        return copyCars;
    }
}
