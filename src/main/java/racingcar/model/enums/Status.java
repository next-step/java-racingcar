package racingcar.model.enums;

public enum Status {
    FORWARD, STOP;

    public static Status extractByNumber(int number) {
        if (number >= 4 && number <= 9) {
            return FORWARD;
        }
        return STOP;
    }
}
