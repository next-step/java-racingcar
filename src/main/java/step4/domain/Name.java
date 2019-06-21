package step4.domain;

import org.apache.commons.lang3.StringUtils;

public class Name {
    private String name;

    Name(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("이름을 입력하세요.");
        }
        this.name = name;
    }
}
