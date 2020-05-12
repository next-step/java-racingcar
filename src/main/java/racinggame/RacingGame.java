package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private RacingCar[] racingCars;
    private int round;
    private List<int[]> roundCarPositions;

    public RacingGame(int carCount, int round) {
        validateRacingGame(carCount, round);

        createRacingCars(carCount);
        this.round = round;
        this.roundCarPositions = new ArrayList<>();
    }

    private void validateRacingGame(int carCount, int round) {
        if (carCount <= 0 || round <= 0) {
            throw new IllegalArgumentException("자동차 대수와 이동 횟수는 0 보다 커야 합니다.");
        }
    }

    private void createRacingCars(int carCount) {
        this.racingCars = new RacingCar[carCount];
        for (int i = 0; i < carCount; i++) {
            this.racingCars[i] = RacingCar.newRacingCar();
        }
    }

    public void start() {
        for (int i = 0; i < this.round; i++) {
            moveRacingCars();
            addRoundCarPositions();
        }
    }

    private void moveRacingCars() {
        Arrays.stream(this.racingCars).forEach(RacingCar::move);
    }

    private void addRoundCarPositions() {
        this.roundCarPositions.add(getCurrentRacingCarPositions());
    }

    private int[] getCurrentRacingCarPositions() {
        return Arrays.stream(this.racingCars)
                .mapToInt(RacingCar::currentPosition)
                .toArray();
    }

    public List<int[]> getRoundCarPositions() {
        return this.roundCarPositions;
    }
}
