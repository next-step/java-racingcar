package calculator;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    private static final String SCHEME_SEPARATOR = " ";

    public static int execute(String formula) {
        validFormula(formula);
        String[] keywords = formula.split(SCHEME_SEPARATOR);
        int answer = parseInt(keywords[0]);
        for (int index = 2; index < keywords.length; index+=2) {
            Operation shape = Operation.findOf(keywords[index - 1]);
            answer = shape.execute(answer, parseInt(keywords[index]));
        }
        return answer;
    }

    private static void validFormula(String value) {
        if(Objects.isNull(value)) {
            throw new IllegalArgumentException("null 을 계산할 수 없습니다.");
        }
        if(SCHEME_SEPARATOR.equals(value)) {
            throw new IllegalArgumentException("공백 문자는 계산할 수 없습니다.");
        }
    }
}
