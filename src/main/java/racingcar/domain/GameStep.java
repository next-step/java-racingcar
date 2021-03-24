package racingcar.domain;

import java.util.Objects;

public class GameStep {
    private final static int START_STEP = 0;
    private final static int STEP_INCREASE = 1;

    private int nowStep;
    private final int stepNumber;

    public GameStep(int stepNumber) {
        this.stepNumber = stepNumber;
        nowStep = START_STEP;
    }

    public GameStep(int nowStep, int stepNumber) {
        this.nowStep = nowStep;
        this.stepNumber = stepNumber;
    }

    public Boolean isRunning() {
        return nowStep < stepNumber;
    }

    public void increaseStep() {
        nowStep += STEP_INCREASE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameStep gameStep = (GameStep) o;
        return nowStep == gameStep.nowStep && stepNumber == gameStep.stepNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nowStep, stepNumber);
    }
}
