package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    private RuleStrategy ruleStrategy;

    public GameManager(RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    public List<Car> readyCars(int num, MoveStrategy moveStrategy) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car(moveStrategy))
                .collect(Collectors.toList());
    }

    public void playOneRound(List<Car> cars) {
        cars.stream().forEach(c -> {
            if (ruleStrategy.checkRule())
                c.move();
        });
    }
}
