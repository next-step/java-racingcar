package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Racing {
    private final List<Car> racingCars;
    private final int matchCount;
    private final List<List<Integer>> scoreBoard = new ArrayList<>();
    private static final Random random = new Random();

    public Racing(int carCount, int matchCount) {
        this.racingCars = this.racingCarRegistration(carCount);
        this.matchCount = matchCount;
    }

    private List<Car> racingCarRegistration(int carCount) {
        final Car[] racingCars = new Car[carCount];

        for (int i = 0; i < carCount; i++) {
            racingCars[i] = new Car();
        }

        return Arrays.asList(racingCars);
    }

    public void raceStart() {
        for (int i = 0; i < this.matchCount; i++) {
            this.carMove();
            this.insertScore();
        }
    }

    private void carMove() {
        for (Car car : this.racingCars) {
            car.move(random.nextInt(10));
        }
    }

    private void insertScore() {
        final List<Integer> currentScore = new ArrayList<>();

        for (Car car : this.racingCars) {
            currentScore.add(car.currentLocation());
        }

        this.scoreBoard.add(currentScore);
    }

    public List<List<Integer>> scoreBoard() {
        return this.scoreBoard;
    }
}