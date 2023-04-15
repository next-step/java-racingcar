package step3.domain;

import step3.strategy.move.MoveStrategy;

import java.util.List;

public class UsingRacingCarStage {

    private final Reps reps;
    private final List<UsingNameRacingCar> usingNameRacingCarList;

    private UsingRacingCarStage(Reps reps, List<UsingNameRacingCar> usingNameRacingCarList) {
        this.reps = reps;
        this.usingNameRacingCarList = usingNameRacingCarList;
    }

    public List<UsingNameRacingCar> getCarList() {
        return usingNameRacingCarList;
    }

    public static UsingRacingCarStage of(Reps reps, List<UsingNameRacingCar> usingNameRacingCarList) {
        return new UsingRacingCarStage(reps, usingNameRacingCarList);
    }

    public UsingRacingCarStage play(MoveStrategy moveStrategy) {
        reps.repsDown();
        usingNameRacingCarList.forEach(racingCar -> racingCar.move(moveStrategy));
        return this;
    }


}

