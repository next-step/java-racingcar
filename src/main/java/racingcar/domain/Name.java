package racingcar.domain;

import org.codehaus.plexus.util.StringUtils;

public class Name {
    private final String name;

    public Name(String name) {
        checkValidName(name);
        this.name = name.trim();
    }

    private void checkValidName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("적합한 이릅이 아닙니다.");
        }
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if (o instanceof Name == false) {
            return false;
        }

        return name.equals(((Name) o).name);
    }
}
