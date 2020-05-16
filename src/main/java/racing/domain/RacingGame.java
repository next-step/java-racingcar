package racing.domain;

import racing.dto.CarRaceResult;
import racing.dto.RaceInformation;
import racing.utils.EmptyCheckUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MIN_RACING_COUNT = 1;
    private static final int MIN_CAR_COUNT = 1;

    private int racingTotalRound = 0;
    private int currentRacingCount = 0;
    private List<Car> cars = new ArrayList<>();
    private CarMovement carMovement;

    public RacingGame(RaceInformation raceInformation, CarMovement carMovement) {
        EmptyCheckUtil.emptyCheck(raceInformation);
        EmptyCheckUtil.emptyCheck(carMovement);
        this.validateRacingTotalRound(raceInformation.getTotalRacingCount());
        this.validateCarNames(raceInformation.getCarNames());
        this.validateCarMovement(carMovement);

        this.carMovement = carMovement;
        this.racingTotalRound = raceInformation.getTotalRacingCount();

        String[] carNames = raceInformation.getCarNames();
        this.createCars(carNames);
    }

    private void createCars(String[] carNames) {
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
        EmptyCheckUtil.emptyCheck(carName);
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

    public List<CarRaceResult> calculateCarRaceResults() {
        return this.cars.stream()
                .map(car -> new CarRaceResult(car.getName(), car.findCurrentPosition()))
                .collect(Collectors.toList());
    }
}
