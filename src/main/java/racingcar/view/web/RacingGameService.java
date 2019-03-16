package racingcar.view.web;

import racingcar.domain.Race;
import racingcar.domain.RacingCar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameService {
    public static Map<String, Object> getNames(final String[] carNames) {
        List<RacingCarDto> cars = new ArrayList<>(carNames.length);

        for (String name : carNames) {
            cars.add(new RacingCarDto(name));
        }

        Map<String, Object> result = new HashMap<>();

        result.put("cars", cars);

        return result;
    }

    public static Map<String, Object> startGame(final String[] carNames, final int turn) {
        Race race = new Race(carNames);
        List<RaceDto> carsByRaces = new ArrayList<>();

        for (int i = 1; i <= turn; i++) {
            RaceDto raceDto = new RaceDto("Race " + i, copyCars(race.play()));

            carsByRaces.add(raceDto);
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

    private static List<RacingCarDto> copyCars(List<RacingCar> cars) {
        List<RacingCarDto> copyCars = new ArrayList<>(cars.size());

        for (RacingCar car : cars) {
            RacingCarDto carDto = new RacingCarDto(car);
            copyCars.add(carDto);
        }

        return copyCars;
    }
}
