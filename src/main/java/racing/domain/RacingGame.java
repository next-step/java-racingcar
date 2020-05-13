package racing.domain;

import racing.dto.RacingCreateValueObject;
import racing.dto.RacingGameResult;

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
        this.validateRacingTotalRound(racingCreateValueObject.getTotalRacingCount());
        this.validateCarNames(racingCreateValueObject.getCarNames());
        this.validateCarMovement(carMovement);

        this.carMovement = carMovement;
        this.racingTotalRound = racingCreateValueObject.getTotalRacingCount();
        String[] carNames = racingCreateValueObject.getCarNames();
        for (String carName: carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private void validateRacingTotalRound(int racingTotalRound) {
        if (racingTotalRound < MIN_RACING_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNames(String[] carNames) {
        if (Objects.isNull(carNames)) {
            throw new IllegalArgumentException();
        }

        if (carNames.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException();
        }

        for (String carName: carNames) {
            this.validateCarNameEmptyCheck(carName);
        }
    }

    private void validateCarNameEmptyCheck(String carName) {
        if (Objects.isNull(carName) || carName.isEmpty()) {
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

    public RacingGameResult calculateRacingGameResult() {
        return new RacingGameResult(this.cars);
    }
}
