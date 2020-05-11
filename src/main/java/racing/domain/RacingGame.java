package racing.domain;

import racing.dto.RacingCreateDto;
import racing.dto.RacingResultDto;

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

    public RacingGame(RacingCreateDto racingCreateDto, CarMovement carMovement) {
        this.validateRacingTotalRound(racingCreateDto.totalRacingCount());
        this.validateCarCount(racingCreateDto.carCount());
        this.validateCarMovement(carMovement);

        this.carMovement = carMovement;
        this.racingTotalRound = racingCreateDto.totalRacingCount();
        for (int i = 0; i < racingCreateDto.carCount(); i++) {
            this.cars.add(new Car());
        }
    }

    private void validateRacingTotalRound(int racingTotalRound) {
        if (racingTotalRound < this.MIN_RACING_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarCount(int carCount) {
        if (carCount < this.MIN_CAR_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarMovement(CarMovement carMovement) {
        if (Objects.isNull(carMovement)) {
            throw new IllegalArgumentException();
        }
    }

    public RacingResultDto racingResult() {
        List<Integer> result = new ArrayList<>();
        if (this.racingTotalRound > this.currentRacingCount) {
            this.cars.forEach(car -> {
                car.move(this.carMovement);
                result.add(car.currentPosition());
            });

            this.currentRacingCount++;
        }

        return new RacingResultDto(result);
    }
}
