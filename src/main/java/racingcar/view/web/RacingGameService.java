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

    public static GameResult startGame(final String[] carNames, final int turn)
        throws CloneNotSupportedException {

        GameResult gameResult = new GameResult();
        Race race = new Race(carNames);

        for (int i = 1; i <= turn; i++) {
            gameResult.addRaceResult(new RaceResult("Race " + i, copyCars(race.play())));
        }

        gameResult.setWinnerNames(GameResult.extractWinnerNamesOf(race));

        return gameResult;
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
