package racingcar.model.enums;

import racingcar.model.wrapper.ForwardNumber;

public enum Status {
    FORWARD("-"), STOP("");
    private final String printStatus;

    Status(String printStatus) {
        this.printStatus = printStatus;
    }
    public static Status extractByNumber(ForwardNumber number) {
        if (number.isForwardNumber()) {
            return FORWARD;
        }
        return STOP;
    }

    public String printStatus() {
        return this.printStatus;
    }
}
