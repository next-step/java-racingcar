package step5.domain;

import step5.strategy.move.MoveStrategy;

public class Stage {

    private final RacingInformation racingInformation;

    public Stage(RacingInformation racingInformation) {
        this.racingInformation = racingInformation;
    }

    public void play(MoveStrategy moveStrategy) {
        racingInformation.getReps().repsDown();
        racingInformation.getRacingCarGroup().move(moveStrategy);
    }

    public boolean hasMoreStage() {
        return racingInformation.isContinue();
    }

    public int getCurrentStage() {
        return racingInformation.getReps().getReps();
    }
}

