package racingcar.domain;

import racingcar.domain.movableStrategy.MovableStrategy;

import java.util.List;
import java.util.Objects;

public class CarRacing {
    private final RacingFleet racingFleet;
    private final RacingHistories histories;
    private final MovableStrategy movableStrategy;

    private CarRacing(RacingFleet racingFleet, RacingHistories histories, MovableStrategy movableStrategy) {
        this.racingFleet = racingFleet;
        this.histories = histories;
        this.movableStrategy = movableStrategy;
    }

    public static CarRacing valueOf(List<String> carNames,  MovableStrategy movableStrategy) {
        RacingFleet racingFleet = initializeRacingCars(carNames);
        RacingHistories histories = initializeRacingHistories(racingFleet);
        return new CarRacing(racingFleet, histories, movableStrategy);
    }

    private static RacingFleet initializeRacingCars(List<String> carNames) {
        return RacingFleet.valueOf(carNames);
    }

    private static RacingHistories initializeRacingHistories(RacingFleet racingFleet) {
        return RacingHistories.newInstance(racingFleet);
    }

    public void proceedWraps(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            proceedWrap();
        }
    }

    private void proceedWrap() {
        racingFleet.raceAll(movableStrategy);
        this.histories.recordRacingState(racingFleet);
    }

    public RacingHistories getHistories() {
        return this.histories;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingFleet.getRacingCars();
    }

    public List<RacingCar> findWinners() {
        return this.racingFleet.findWinners();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRacing carRacing = (CarRacing) o;
        return Objects.equals(racingFleet, carRacing.racingFleet) && Objects.equals(histories, carRacing.histories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingFleet, histories);
    }
}
