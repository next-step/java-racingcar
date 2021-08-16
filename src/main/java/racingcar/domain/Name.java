package racingcar.domain;

import org.codehaus.plexus.util.StringUtils;

public class Name {
    private final String name;

    public Name(String name) {
        checkValidName(name);
        this.name = name;
    }

    private void checkValidName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("적합한 이릅이 아닙니다.");
        }
    }

    public String getName() {
        return name;
    }
}
