package car.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private List<Car> aRoundResult;

    private GameResult() {
        aRoundResult = new ArrayList<>();
    }

    public static GameResult createResultInstance(List<Car> result) {
        GameResult gameResult = new GameResult();
        gameResult.aRoundResult = result;
        return gameResult;
    }

    public List<Car> getRoundResult() {
        return aRoundResult;
    }


    public List<String> getWinnerNames() {
        int maxMovement = getMaxMovement();
        return aRoundResult.stream()
                .filter(car -> car.getMovingCount() >= maxMovement)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public int getMaxMovement() {
        return aRoundResult.stream()
                .mapToInt(car -> car.getMovingCount())
                .max()
                .orElse(0);
    }
}
