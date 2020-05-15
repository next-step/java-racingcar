package racingcar;

import org.apache.commons.lang3.StringUtils;

public class CarName {

    private String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    private void validate(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }
}
