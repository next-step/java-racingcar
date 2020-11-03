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
        GameRounds gameRounds = new GameRounds(gameRoundNum);
        List<Record> records = new ArrayList<>();

        while (!gameRounds.isGameEnd()) {
            playOneRound(cars);
            gameRounds.endRound();
            records.add(gameRounds.getRecord(cars));
        }

        return records;
    }

    private List<Car> readyCars(int num) {
        return IntStream.range(0, num)
                .mapToObj(i -> new Car(ruleStrategy))
                .collect(Collectors.toList());
    }

    private void playOneRound(List<Car> cars) {
        cars.stream().forEach(car -> car.move());
    }
}
