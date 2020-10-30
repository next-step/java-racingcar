package study.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Expression {

    String value;

    public Expression(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression은 빈값이나 Null일 수 없습니다.");
        }
    }

    /*

    public String getValue() {
        return value;
    }
    */

    public List<String> getSplittedStrings(String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }

}
