package racingcar.domain;

import racingcar.domain.movableStrategy.RandomMovableStrategy;
import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingWrapResultDTO;
import racingcar.dto.RacingWrapResultsDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class CarRacing {
    private final RacingFleet racingFleet;
    private final RacingHistories histories;

    private CarRacing(RacingFleet racingFleet, RacingHistories histories) {
        this.racingFleet = racingFleet;
        this.histories = histories;
    }

    public static CarRacing valueOf(List<String> carNames) {
        RacingFleet racingFleet = initializeRacingCars(carNames);
        RacingHistories histories = initializeRacingHistories(racingFleet);
        return new CarRacing(racingFleet, histories);
    }

    private static RacingFleet initializeRacingCars(List<String> carNames) {
        return RacingFleet.valueOf(carNames);
    }

    private static RacingHistories initializeRacingHistories(RacingFleet racingFleet) {
        List<RacingHistory> histories = new ArrayList<>();
        histories.add(RacingHistory.valueOf(0, RacingCarStates.valueOf(racingFleet)));
        return RacingHistories.valueOf(histories);
    }

    public void proceedWraps(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            proceedWrap();
        }
    }

    private void proceedWrap() {
        int currentWrapNo = findCurrentWrapNo();
        racingFleet.raceAll(RandomMovableStrategy.getInstance());
        RacingCarStates carStates = RacingCarStates.valueOf(racingFleet);
        this.histories.value().add(RacingHistory.valueOf(currentWrapNo + 1, carStates));
    }

    private int findCurrentWrapNo() {
        return Collections.max(this.histories.value(), Comparator.comparingInt(RacingHistory::getWrapNumber)).getWrapNumber();
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
