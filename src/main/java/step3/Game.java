package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final Integer time;
    private final Integer count;
    private final MoveStrategy moveStrategy;
    private final List<Car> cars = new ArrayList<>();
    private final GameHistory gameHistory = new GameHistory();

    private Game(Integer count, Integer time, MoveStrategy moveStrategy) {
        this.time = time;
        this.count = count;
        this.moveStrategy = moveStrategy;
    }

    public static Game of(Rule rule, MoveStrategy moveStrategy) {
        InputValidator.isNull(rule.getCount());
        InputValidator.isNull(rule.getTime());

        return new Game(rule.getCount(), rule.getTime(), moveStrategy);
    }

    public void start() {
        addCar();
        for (int now = 0; now < this.time; now++) {
            step();
            addHistory(now);
        }
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

    private void addHistory(Integer now) {
        List<Position> log = getLog();
        gameHistory.save(now, log);
    }

    private List<Position> getLog() {
        return this.cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    private void addCar() {
        for (int i = 0; i < this.count; i++) {
            cars.add(Car.create(moveStrategy));
        }
    }

    private void step() {
        this.cars.stream()
                .forEach(car -> car.moveOrStop());
    }
}
