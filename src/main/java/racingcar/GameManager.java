package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    private final RuleStrategy ruleStrategy;

    public GameManager(RuleStrategy ruleStrategy) {
        this.ruleStrategy = ruleStrategy;
    }

    public List<Record> play(int carNum, int gameRoundNum) {
        List<Car> cars = readyCars(carNum);
        GameRound gameRound = new GameRound(gameRoundNum);
        List<Record> records = new ArrayList<>();

        while (!gameRound.isGameEnd()) {
            playOneRound(cars);
            gameRound.endRound();
            records.add(gameRound.getRecord(cars));
        }

        return records;
    }

    private List<Car> readyCars(int num) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car(ruleStrategy))
                .collect(Collectors.toList());
    }

    public void playOneRound(List<Car> cars) {
        cars.stream().forEach(c -> c.move());
    }
}
