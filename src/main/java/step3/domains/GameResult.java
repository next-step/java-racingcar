package step3.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<List<Car>> resultList;

    public static GameResult init() {
        return new GameResult(new ArrayList<>());
    }

    GameResult(List<List<Car>> resultList) {
        this.resultList = resultList;
    }

    public GameResult addResult(List<Car> result) {
        List<List<Car>> copyResultList = List.copyOf(resultList);
        copyResultList.add(result);

        return new GameResult(copyResultList);
    }

    public List<List<Car>> getResults() {
        return this.resultList;
    }

    public List<Car> getWinners() {
        List<Car> lastResult = resultList.get(resultList.size() - 1);

        int winnerPosition = lastResult.stream()
                .max(Car::compareTo)
                .map(Car::getPosition)
                .orElse(0);

        return lastResult.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());
    }
}
