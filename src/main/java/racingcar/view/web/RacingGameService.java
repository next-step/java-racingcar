package racingcar.view.web;

import java.util.Arrays;
import racingcar.domain.Race;
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
            gameResult.addRaceResult(race.play().clone());
        }

        gameResult.endGame();

        return gameResult;
    }
}
