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
    private final RacingWrapResultsDTO wrapResults;

    private CarRacing(RacingFleet racingFleet, RacingWrapResultsDTO wrapResults) {
        this.racingFleet = racingFleet;
        this.wrapResults = wrapResults;
    }

    public static CarRacing valueOf(List<String> carNames) {
        RacingFleet racingFleet = initializeRacingCars(carNames);
        List<RacingWrapResultDTO> wrapResults = initializeWrapResults(racingFleet);
        return new CarRacing(racingFleet, RacingWrapResultsDTO.valueOf(wrapResults));
    }

    private static RacingFleet initializeRacingCars(List<String> carNames) {
        return RacingFleet.valueOf(carNames);
    }

    private static List<RacingWrapResultDTO> initializeWrapResults(RacingFleet racingFleet) {
        List<RacingWrapResultDTO> wrapResults = new ArrayList<>();
        wrapResults.add(RacingWrapResultDTO.valueOf(0, RacingCarStatesDTO.valueOf(racingFleet)));
        return wrapResults;
    }

    public void proceedWraps(int tryNumber) {
        for (int i = 0; i < tryNumber; i++) {
            proceedWrap();
        }
    }

    private void proceedWrap() {
        int currentWrapNo = findCurrentWrapNo();
        racingFleet.raceAll(RandomMovableStrategy.getInstance());
        RacingCarStatesDTO carStates = RacingCarStatesDTO.valueOf(racingFleet);
        this.wrapResults.getWrapResults().add(RacingWrapResultDTO.valueOf(currentWrapNo + 1, carStates));
    }

    private int findCurrentWrapNo() {
        return Collections.max(this.wrapResults.getWrapResults(), Comparator.comparingInt(RacingWrapResultDTO::getWrapNumber)).getWrapNumber();
    }

    public RacingWrapResultsDTO getWrapResults() {
        return this.wrapResults;
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
        return Objects.equals(racingFleet, carRacing.racingFleet) && Objects.equals(wrapResults, carRacing.wrapResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingFleet, wrapResults);
    }
}
