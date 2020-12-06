package racing.domain;

import org.apache.commons.lang3.StringUtils;

public class CarName implements Cloneable {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throwWrongNameException();
        }

        if (name.length() > MAX_LENGTH) {
            throwWrongNameException();
        }
    }

    private void throwWrongNameException() {
        throw new IllegalArgumentException("잘못된 이름입니다.");
    }

    public String getName() {
        return name;
    }

    @Override
    protected CarName clone() throws CloneNotSupportedException {
        return (CarName) super.clone();
    }
}