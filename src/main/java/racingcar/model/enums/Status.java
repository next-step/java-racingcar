package racingcar.model.enums;

import racingcar.model.wrapper.ForwardNumber;

public enum Status {
    FORWARD, STOP;

    public static Status extractByNumber(ForwardNumber number) {
        if (number.isForwardNumber()) {
            return FORWARD;
        }
        return STOP;
    }

}
