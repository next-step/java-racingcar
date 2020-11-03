package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameRounds {
    private int round;

    public GameRounds(int round) {
        this.round = round;
    }

    public void endRound() {
        round--;
    }

    public Record getRecord(List<Car> cars) {
        return new Record(cars.stream()
                .map(car -> car.getPosition())
                .collect(Collectors.toList()));
    }

    public boolean isGameEnd() {
        return round == 0;
    }
}
