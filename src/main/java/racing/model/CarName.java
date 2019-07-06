package racing.model;

import org.apache.commons.lang3.StringUtils;

public class CarName {

    private static final String EXCEPTION_MESSAGE_INVALID_NAME = "자동차 이름이 입력되어야 합니다.";
    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name))
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_NAME);
    }

    public String getName() {
        return name;
    }
}
