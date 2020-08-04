package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRound {
    private List<RacingCar> racingCarList;

    public RacingRound(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public void race(Rule racingRule) {
        this.racingCarList.forEach(racingCar -> racingCar.run(racingRule));
    }

    public String getRoundRecord() {
        return this.racingCarList.stream()
                .map(racingCar -> racingCar.makeMark(racingCar.getCarPosition()))
                .collect(Collectors.joining("\n"));
    }

}
