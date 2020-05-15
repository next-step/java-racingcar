package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int round;
    private List<int[]> resultCarPositions;

    public RacingGame(int carCount, int round, MovableStrategy movableStrategy) {
        validateRacingGame(carCount, round);

        createRacingCars(carCount, movableStrategy);
        this.round = round;
        this.resultCarPositions = new ArrayList<>();
    }

    private void validateRacingGame(int carCount, int round) {
        if (carCount <= 0 || round <= 0) {
            throw new IllegalArgumentException("자동차 대수와 이동 횟수는 0 보다 커야 합니다.");
        }
    }

    private void createRacingCars(int carCount, MovableStrategy movableStrategy) {
        this.racingCars = Stream.generate(() -> RacingCar.newInstance(movableStrategy))
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public void start() {
        for (int i = 0; i < this.round; i++) {
            moveRacingCars();
            addResultCarPositions();
        }
    }

    private void moveRacingCars() {
        this.racingCars.forEach(RacingCar::move);
    }

    private void addResultCarPositions() {
        this.resultCarPositions.add(getCurrentRacingCarPositions());
    }

    private int[] getCurrentRacingCarPositions() {
        return this.racingCars.stream()
                .mapToInt(RacingCar::currentPosition)
                .toArray();
    }

    public ResultCarPositions getResultCarPositions() {
        return ResultCarPositions.newInstance(this.resultCarPositions);
    }
}
