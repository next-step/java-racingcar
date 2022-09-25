package step3;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Game {
    private Integer totalTryCount;
    private Integer counter;
    private List<Car> cars;

    public Game(int totalTryCount, int carCount) {
        this.totalTryCount = totalTryCount;
        this.counter = 0;
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(i));
        }
    }

    public static Game prepare(RacingCondition racingCondition) {
        return new Game(racingCondition.getAttemptCount(), racingCondition.getCarCount());
    }

    public boolean isEnded() {
        return Objects.equals(totalTryCount, counter);
    }

    public void play() {
        for (int tryCount = 0; tryCount < totalTryCount; tryCount++) {
            doTry();
            new GameDashBoard(cars).show();
        }
    }

    private void doTry() {
        counter++;
        Random random = new Random(System.currentTimeMillis());

        for (Car car : cars) {
            car.tryMove(random.nextInt(GameRule.RANDOM_LIMIT));
        }
    }
}