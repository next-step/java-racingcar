package racing.domain;

import racing.rule.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameRound {

    List<Integer> roundResults = new ArrayList<>();

    public void racing(List<Car> cars, MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
            roundResults.add(car.getForwardCount());
        }
    }

    public List<Integer> getRoundResults() {
        return roundResults;
    }
}