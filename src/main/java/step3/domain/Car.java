package step3.domain;

import org.apache.commons.lang3.StringUtils;

public class Car {

    private static final String BLANK_EXCEPTION = "잘못된 인자값 입니다.";

    private String move;
    private int status;

    public Car() {
        this.status = 0;
    }

    public Car(String move) {
        moveArgException(move);

    }

    public int moveCar() {
        return status;
    }

    private void moveArgException(String number) throws IllegalArgumentException {

        try {
            if (!StringUtils.isNumeric(number) || StringUtils.isBlank(number)) {
                throw new IllegalArgumentException(BLANK_EXCEPTION);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }
}
