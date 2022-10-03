package step3.domains;

import java.util.ArrayList;
import java.util.Collections;
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
        List<List<Car>> copyResultList = new ArrayList<>(resultList);
        copyResultList.add(result);

        return new GameResult(copyResultList);
    }

    public List<List<Car>> getResults() {
        return this.resultList;
    }

    public List<Car> getWinners() {
        if (resultList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<Car> lastResult = resultList.get(resultList.size() - 1);

        Car winner = lastResult.stream()
                .reduce((c1, c2) -> c1.isWinner(c2) ? c1 : c2)
                .get();

        return lastResult.stream()
                .filter(car -> car.isWinner(winner))
                .collect(Collectors.toList());
    }
}
