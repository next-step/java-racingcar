package carracing.model;

import carracing.util.RandomUtils;

public class Car {

    public static final Integer MIN_FORWARD_NUMBER = 4;

    private String name;

    private RacingHitory racingHitory;

    public Car(Integer idx) {
        this.name = String.valueOf(idx);
        this.racingHitory = new RacingHitory();
    }

    public void runRace() {
        racingHitory.addHistory(isRun());
    }

    private Boolean isRun() {
        return RandomUtils.nextInt() >= MIN_FORWARD_NUMBER;
    }

    public Long getSuccessCountByIndex(Integer toIndex) {
        return this.racingHitory.getSuccessCountByIndex(toIndex);
    }

}
