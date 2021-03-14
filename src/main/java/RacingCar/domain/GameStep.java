package RacingCar.domain;

import RacingCar.view.InputView;

public class GameStep {
    private final static int START_STEP = 0;
    private final static int STEP_INCREASE = 1;

    private int nowStep;
    private final int stepNumber;

    public GameStep() {
        stepNumber = InputView.getStepNumber();
        nowStep = START_STEP;
    }

    public Boolean isRunning() {
        return nowStep < stepNumber;
    }

    public void increaseStep() {
        nowStep += STEP_INCREASE;
    }

}
