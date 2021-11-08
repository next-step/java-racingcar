package carracing.model;

import carracing.util.RandomUtils;

public class Car {

    public static final Integer MIN_FORWARD_NUMBER = 4;

    private String name;

    private RacingHistory racingHistory;

    public Car(Integer idx) {
        this.name = String.valueOf(idx);
        this.racingHistory = new RacingHistory();
    }

    public void runRace() {
        racingHistory.addHistory(isRun());
    }

    private Boolean isRun() {
        return RandomUtils.nextInt() >= MIN_FORWARD_NUMBER;
    }

    public Long getSuccessCountByIndex(Integer toIndex) {
        return this.racingHistory.getSuccessCountByIndex(toIndex);
    }

}
