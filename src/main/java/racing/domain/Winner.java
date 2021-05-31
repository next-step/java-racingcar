package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Winner {
    public List<String> findWinner(List<Car> cars) {
        int winnerCount = findMaxMoveCount(cars);
        return findCorrespondMoveCountCarNames(cars, winnerCount);
    }

    private int findMaxMoveCount(List<Car> cars) {
        Cars carNames = new Cars(cars);
        return carNames.findMaxMoveCountCar();
    }

    private List<String> findCorrespondMoveCountCarNames(List<Car> cars, int moveCount) {
        Cars carNames = new Cars(cars);
        return carNames.findCorrespondMoveCountCarNames(moveCount);
    }
}
