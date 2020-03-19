package stringcalculator;

public class Expression {
    private static final String DELIMITER = " ";
    private String[] expressions;

    public Expression(String source) {
        if (source == null || "".equals(source.trim())) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        this.expressions = source.split(DELIMITER);
    }

    public String[] getExpression() {
        return expressions;
    }
}
