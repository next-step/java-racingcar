package step2;

import java.util.Objects;

public class StringParser {
    private final String value;

    public StringParser(String value) {
        validate(value);

        this.value = value;
    }

    private void validate(String value) {

        if (Objects.isNull(value) || value.isBlank())
            throw new IllegalArgumentException("입력 값이 null 이거나 빈 공백 문자입니다");
    }

    public String[] parse() {
        return value.split(" ");
    }
}
