package racingCar.domain;

public enum Condition {
    GO,
    STOP;

    public static Condition CheckCondition(int condition) {
        if(condition >= 4) {
            return GO;
        }
        return STOP;
    }

    public boolean isGo() {
        return this == GO;
    }
}
