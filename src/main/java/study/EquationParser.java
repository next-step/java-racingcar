package study;

public class EquationParser {

    private static final String EQUATION_DELIMITER = " ";

    public String[] parse(String equation) {
        validate(equation);
        equation = equation.trim();

        return equation.split(EQUATION_DELIMITER);
    }

    private void validate(String equation) {
        if (equation == null || equation.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 공백일 수 없습니다.");
        }
    }

}
