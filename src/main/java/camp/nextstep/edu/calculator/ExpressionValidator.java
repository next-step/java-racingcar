package camp.nextstep.edu.calculator;

import camp.nextstep.edu.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator implements Validator<String> {
    private static final Pattern PATTERN_EXPRESSION = Pattern.compile("(\\d+)(?:\\s+([\\+\\-\\*\\/])\\s+(\\d+))*");

    @Override
    public void validate(String expression) {
        if (StringUtils.isEmpty(expression)) {
            throw new IllegalArgumentException("문자열 수식은 빈 문자열이 아니어야 하고, null 이 아니어야 합니다.");
        }

        final Matcher matcher = PATTERN_EXPRESSION.matcher(expression);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다. ");
        }
    }
}
