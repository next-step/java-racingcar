package racingcar.domain;

import racingcar.domain.movableStrategy.RandomMovableStrategy;
import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingWrapResultDTO;
import racingcar.dto.RacingWrapResultsDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarRacing {
    private final List<RacingCar> racingCars;
    private final RacingWrapResultsDTO wrapResults;

    private CarRacing(List<RacingCar> racingCars, RacingWrapResultsDTO wrapResults) {
        this.racingCars = racingCars;
        this.wrapResults = wrapResults;
    }

    public static CarRacing valueOf(List<String> carNames) {
        List<RacingCar> racingCars = initializeRacingCars(carNames);
        List<RacingWrapResultDTO> wrapResults = initializeWrapResults(racingCars);
        return new CarRacing(racingCars, RacingWrapResultsDTO.valueOf(wrapResults));
    }

    private static List<RacingCar> initializeRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int carNumber = 0; carNumber < carNames.size(); carNumber++) {
            racingCars.add(RacingCar.valueOf(carNames.get(carNumber), carNumber));
        }
        return racingCars;
    }

    private static List<RacingWrapResultDTO> initializeWrapResults(List<RacingCar> racingCars) {
        List<RacingWrapResultDTO> wrapResults = new ArrayList<>();
        wrapResults.add(RacingWrapResultDTO.valueOf(0, RacingCarStatesDTO.valueOf(racingCars)));
        return wrapResults;
    }

    public void proceedWrap() {
        int currentWrapNo = findCurrentWrapNo();
        this.racingCars.forEach(racingCar -> racingCar.race(RandomMovableStrategy.getInstance()));
        RacingCarStatesDTO carStates = RacingCarStatesDTO.valueOf(this.racingCars);
        this.wrapResults.getWrapResults().add(RacingWrapResultDTO.valueOf(currentWrapNo + 1, carStates));
    }

    private int findCurrentWrapNo() {
        return Collections.max(this.getWrapResults().getWrapResults(), Comparator.comparingInt(RacingWrapResultDTO::getWrapNumber)).getWrapNumber();
    }

    public RacingWrapResultsDTO getWrapResults() {
        return this.wrapResults;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRacing carRacing = (CarRacing) o;
        return Objects.equals(racingCars, carRacing.racingCars) && Objects.equals(wrapResults, carRacing.wrapResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars, wrapResults);
    }
}
