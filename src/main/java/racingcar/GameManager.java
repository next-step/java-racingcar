package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    public List<Car> readyCars(int num, RuleStrategy ruleStrategy) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car(ruleStrategy))
                .collect(Collectors.toList());
    }

    public void playOneRound(List<Car> cars) {
        cars.stream().forEach(c -> c.move());
    }
}
