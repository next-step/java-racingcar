package racingCar.domain;

public enum Condition {
    GO,
    STOP;

    private static final int START_CONDITION = 4;
    private static final int END_CONDITION = 9;

    public static Condition CheckCondition(int condition) {
        if(condition >= START_CONDITION && condition <= END_CONDITION) {
            return GO;
        }
        return STOP;
    }

    public boolean isGo() {
        return this == GO;
    }
}
