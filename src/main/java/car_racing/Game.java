package car_racing;


import java.util.Objects;
import java.util.stream.IntStream;

public class Game {
    private Integer totalTryCount;
    private Integer counter;
    private Cars cars;

    public Game(int totalTryCount, Cars cars) {
        this.totalTryCount = totalTryCount;
        this.counter = 0;
        this.cars = cars;
    }

    public static Game prepare(Integer attemptCount, Cars cars) {
        return new Game(attemptCount, cars);
    }

    public boolean isEnded() {
        return Objects.equals(totalTryCount, counter);
    }

    public void play() {
        IntStream.range(0, totalTryCount).forEach(notUsed -> doTry());
    }

    private void doTry() {
        counter++;
        cars.goOrStop();
        new GameDashBoard(cars).show();
    }
}