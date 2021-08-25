package carracing.domain;

import org.apache.commons.lang3.StringUtils;

public class Name {

    private final String name;

    public Name(String name, int limitLength) {
        checkNameBlank(name);
        checkNameLength(name, limitLength);

        this.name = name;
    }

    private void checkNameLength(String name, int limitLength) {
        if (name.length() > limitLength) {
            throw new IllegalArgumentException("이름은 " + limitLength + " 이하여야 합니다.");
        }
    }

    private void checkNameBlank(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백이 들어올 수 없습니다.");
        }
    }

}
