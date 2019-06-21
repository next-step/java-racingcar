package step4.domain;

import org.apache.commons.lang3.StringUtils;

public class Name {
    private String name;

    Name(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("올바른 이름이 아닙니다.");
        }
        this.name = name;
    }
}
