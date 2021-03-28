package step4.domain;

import step4.util.StringUtil;

public class Name {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다.");
        }
        if (name.length() > NAME_LENGTH) {
            String message = String.format("자동차 이름이 %d자 초과하였습니다.", NAME_LENGTH);
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
