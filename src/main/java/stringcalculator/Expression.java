package stringcalculator;

import java.util.regex.Pattern;

public class Expression {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d+$");
    private static final int FIRST_INDEX = 0;
    private static final String DELIMITER = " ";

    private String[] expressions;

    public Expression(String source) {
        if (source == null || "".equals(source.trim())) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        String[] split = source.split(DELIMITER);
        if (!INTEGER_PATTERN.matcher(split[FIRST_INDEX]).find()) {
            throw new IllegalArgumentException("입력 값은 숫자부터 시작해야 합니다.");
        }
        this.expressions = split;
    }

    public String[] getExpression() {
        return expressions;
    }
}
