package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RacingCarMovingRule racingCarMovingRule;

    public RacingGame(RacingCarMovingRule racingCarMovingRule) {
        this.racingCarMovingRule = racingCarMovingRule;
    }

    public RacingResult run(List<String> carNameList, int numSteps) {
        ArrayList<RacingCar> racingCarList = buildRacingCarList(carNameList);
        ArrayList<RacingStep> racingStepList = new ArrayList<>();

        racingStepList.add(new RacingStep(racingCarList));

        for (int step = 0; step < numSteps - 1; step++) {
            racingCarList.forEach(racingCar -> racingCar.forward());

            racingStepList.add(new RacingStep(racingCarList));
        }

        return new RacingResult(racingStepList);
    }

    private ArrayList<RacingCar> buildRacingCarList(List<String> carNameList) {
        ArrayList<RacingCar> racingCarList = new ArrayList<>();

        for (String carName : carNameList) {
            racingCarList.add(new RacingCar(carName, racingCarMovingRule));
        }

        return racingCarList;
    }

}
