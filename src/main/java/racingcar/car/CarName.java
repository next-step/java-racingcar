package racingcar.car;

import org.apache.commons.lang3.StringUtils;

public class CarName {
    private String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name) || name.length() > 5) {
            throw new IllegalArgumentException("[" + name + "]잘못된 자동차 이름입니다. 1~5자의 이름을 입력하세요.");
        }
    }

    public static CarName newInstance(String name) {
        return new CarName(name);
    }

    public String getName() {
        return this.name;
    }
}
