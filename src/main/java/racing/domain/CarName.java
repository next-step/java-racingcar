package racing.domain;

import org.apache.commons.lang3.StringUtils;

public class CarName {
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

        if (name.length() > 5) {
            wrongName();
        }
    }

    private void wrongName() {
        throw new IllegalArgumentException("잘못된 이름입니다.");
    }
}
