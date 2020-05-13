package racing.domain;

import racing.dto.RacingCreateValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private static final int MIN_RACING_COUNT = 1;
    private static final int MIN_CAR_COUNT = 1;

    private int racingTotalRound = 0;
    private int currentRacingCount = 0;
    private List<Car> cars = new ArrayList<>();
    private CarMovement carMovement;

    public RacingGame(RacingCreateValueObject racingCreateValueObject, CarMovement carMovement) {
        this.validateRacingTotalRound(racingCreateValueObject.totalRacingCount());
        this.validateCarCount(racingCreateValueObject.carCount());
        this.validateCarMovement(carMovement);

        this.carMovement = carMovement;
        this.racingTotalRound = racingCreateValueObject.totalRacingCount();
        for (int i = 0; i < racingCreateValueObject.carCount(); i++) {
            this.cars.add(new Car());
        }
    }

    private void validateRacingTotalRound(int racingTotalRound) {
        if (racingTotalRound < MIN_RACING_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarCount(int carCount) {
        if (carCount < MIN_CAR_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarMovement(CarMovement carMovement) {
        if (Objects.isNull(carMovement)) {
            throw new IllegalArgumentException();
        }
    }

    public void executeRacing() {
        if (this.racingTotalRound > this.currentRacingCount) {
            this.cars.forEach(car -> car.move(this.carMovement));

            this.currentRacingCount++;
        }

    }

    public List<Integer> calculateRacingScore() {
        List<Integer> result = new ArrayList<>();
        this.cars.forEach(car -> result.add(car.findCurrentPosition()));
        return result;
    }
}
