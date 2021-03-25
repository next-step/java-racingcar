package step4.domain;

import org.junit.platform.commons.util.StringUtils;

public class Name {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
        }
        if (name.length() > NAME_LENGTH) {
            String message = "자동차 이름이 {0}자 초과하였습니다.".replaceAll("\\{0\\}", String.valueOf(NAME_LENGTH));
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
