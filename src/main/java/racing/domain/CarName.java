package racing.domain;

import org.apache.commons.lang3.StringUtils;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            wrongName();
            return;
        }

        if (name.length() > MAX_LENGTH) {
            wrongName();
        }
    }

    private void wrongName() {
        throw new IllegalArgumentException("잘못된 이름입니다.");
    }

    public String getName() {
        return name;
    }
}
