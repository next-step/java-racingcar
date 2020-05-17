package racing.domain;

import racing.dto.CarRaceResult;
import racing.dto.RaceInformation;
import racing.dto.RaceWinnerResult;
import racing.dto.RacingGameResult;
import racing.utils.EmptyCheckUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MIN_RACING_COUNT = 1;

    private int racingTotalRound = 0;
    private int currentRacingCount = 0;
    private List<Car> cars = new ArrayList<>();
    private CarMovement carMovement;
    private RaceWinner raceWinner;

    public RacingGame(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        EmptyCheckUtil.emptyCheck(raceInformation);
        EmptyCheckUtil.emptyCheck(carMovement);
        EmptyCheckUtil.emptyCheck(raceWinner);
        EmptyCheckUtil.emptyCheck(carMovement);
        this.validateRacingTotalRound(raceInformation.getTotalRacingCount());
        this.validateCarNames(raceInformation.getCarNames());

        this.carMovement = carMovement;
        this.racingTotalRound = raceInformation.getTotalRacingCount();
        this.raceWinner = raceWinner;

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
        EmptyCheckUtil.emptyCheck(carNames);
        for (String carName: carNames) {
            this.validateCarNameEmptyCheck(carName);
        }
    }

    private void validateCarNameEmptyCheck(String carName) {
        EmptyCheckUtil.emptyCheck(carName);
    }

    public List<RacingGameResult> executeRacing() {
        List<RacingGameResult> racingGameResults = new ArrayList<>();
        while (this.racingTotalRound > this.currentRacingCount) {
            this.cars.forEach(car -> car.move(this.carMovement));
            this.currentRacingCount++;

            List<CarRaceResult> carRaceResults = this.convertCarRaceResult();
            racingGameResults.add(new RacingGameResult(carRaceResults));
        }
        return racingGameResults;
    }

    private List<CarRaceResult> convertCarRaceResult() {
        return this.cars.stream()
                .map(car -> car.createCarRaceResult())
                .collect(Collectors.toList());
    }

    public RaceWinnerResult calculateWinners() {
        return this.raceWinner.calculateWinners(this.cars);
    }
}
