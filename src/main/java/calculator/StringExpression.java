package calculator;

import java.util.regex.Pattern;

public class StringExpression {

    private final String str;
    private static final Pattern patten = Pattern.compile("^[0-9+*-/\\s]*$");
    private static final String SPLIT_REGEX = " ";

    public StringExpression(String str) {
        if (!isValid(str)) {
            throw new IllegalArgumentException("입력 문자열은 빈 공백 문자열로 구분된 숫자와 사칙 연산자 여야 합니다.");
        }
        this.str = str;
    }

    public String[] split() {
        return str.split(SPLIT_REGEX);
    }

    private boolean isValid(String str) {
        return patten.matcher(str).find();
    }
}
