package step5.domain;

import org.apache.commons.lang3.StringUtils;

public final class Car {
    public final String name;
    public int location = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        this.name = name.trim();
        this.location = location;
    }

    public void moveForward() {
        this.location += 1;
    }
}
