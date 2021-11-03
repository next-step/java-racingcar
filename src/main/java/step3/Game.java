package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Game {

    private static final Random random = new Random();
    private final Long time;
    private final Long count;
    private final List<Car> cars = new ArrayList<>();
    private final GameHistory gameHistory = new GameHistory();

    private Game(Long count, Long time) {
        this.time = time;
        this.count = count;
    }

    public static Game of(Rule rule) {
        InputValidator.isNull(rule.getCount());
        InputValidator.isNull(rule.getTime());

        return new Game(rule.getCount(), rule.getTime());
    }

    public void start() {
        addCar();
        for (Long now = 0L; now < this.time; now++) {
            step();
            addHistory(now);
        }
    }

    public GameHistory getGameHistory() {
        return gameHistory;
    }

    private void addHistory(Long now) {
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
            cars.add(new Car());
        }
    }

    private void step() {
        this.cars.stream()
                .forEach(car -> car.moveOrStop(random.nextInt(10)));
    }
}
