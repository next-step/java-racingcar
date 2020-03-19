package stringcalculator;

public class Expression {
    private final String source;

    public Expression(String source) {
        if (source == null || "".equals(source.trim())) {
            throw new IllegalArgumentException("입력 값은 null 이거나 빈 공백 문자일 수 없습니다.");
        }
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
