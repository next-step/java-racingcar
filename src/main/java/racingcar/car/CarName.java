package racingcar.car;

import org.apache.commons.lang3.StringUtils;
import racingcar.common.ExceptionMessage;

public class CarName {
    private static int MAXIMUM_SIZE = 5;
    private String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name) || name.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_CAR_NAME.buildMessage(name));
        }
    }

    public static CarName newInstance(String name) {
        return new CarName(name);
    }

    public String getName() {
        return this.name;
    }
}
