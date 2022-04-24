package racingcar.model;

import racingcar.pattern.ValueGenerateStrategy;

import java.util.List;
import java.util.Map;

public class RacingGame {
    private static final int ONE_TRIAL = 1;
    private CarGroup carGroup;
    private PositiveNumber trialNumber;

    public RacingGame(String carNameText, PositiveNumber trialNumber) {
        this.carGroup = new CarGroup(carNameText);
        this.trialNumber = trialNumber;
    }

    public List<String> getWinners() {
        return this.carGroup.getWinners();
    }

    public void racing(ValueGenerateStrategy valueGenerateStrategy) {
        this.trialNumber.minus(new PositiveNumber(ONE_TRIAL));
        moveCarGroupPerTrial(valueGenerateStrategy);
    }

    public boolean isRacingDone() {
        return this.trialNumber.isZero();
    }

    private void moveCarGroupPerTrial(ValueGenerateStrategy valueGenerateStrategy) {
        this.carGroup.moveCarGroupPerTrial(valueGenerateStrategy);
    }

    public Map<String, Integer> getCarMap() {
        return carGroup.getCarMap();
    }
}
