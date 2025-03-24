package racingcar.vo;

import racingcar.utils.StringUtils;

public class CarName {

    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (StringUtils.isLengthInvalid(value, 5)) {
            throw new IllegalArgumentException("자동차 이름이 올바르지 않습니다.");
        }
    }
}
