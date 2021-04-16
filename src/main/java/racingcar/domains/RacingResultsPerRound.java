package racingcar.domains;

import java.util.List;

public class RacingResultsPerRound {

    private List<RacingResultForEachCar> racingResultsPerRoundForEachCar;

    public RacingResultsPerRound(List<RacingResultForEachCar> racingResultForEachCars) {
        this.racingResultsPerRoundForEachCar = racingResultForEachCars;
    }

    public int size() {
        return racingResultsPerRoundForEachCar.size();
    }

    public RacingResultForEachCar getRacingResultForEachCar(int carNum) {
        return racingResultsPerRoundForEachCar.get(carNum);
    }

}
