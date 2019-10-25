package calc;

import static calc.utils.NumberUtils.isEven;

import calc.operations.Operators;
import calc.utils.NumberUtils;
import java.util.Objects;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class InputChecker {
    private static final String NULL_INPUT = "아무 것도 입력하지 않았습니다.";
    private static final String ILLEGAL_FORMULA = "입력한 식을 다시 한번 확인해주세요.";
    private String[] formula;

    public InputChecker(String input) {
        this.formula = checkInput(input);
    }

    public String[] getFormula() {
        return formula;
    }

    private String[] checkInput(String input) {
        if (Objects.isNull(input))
            throw new IllegalArgumentException(NULL_INPUT);

        String[] formula = input.split(" ");
        if (isEven(formula.length))
            throw new IllegalArgumentException(ILLEGAL_FORMULA);

        if (!isValidFormula(formula))
            throw new IllegalArgumentException(ILLEGAL_FORMULA);

        return formula;
    }

    private boolean isValidFormula(String[] formula) {
        // 짝수번째 있는 값이 숫자인가?
        if ( !IntStream.range(0, formula.length)
            .filter(NumberUtils::isEven)
            .allMatch(i -> StringUtils.isNumeric(formula[i])) )
            return false;

        // 홀수번째 있는 값이 operation인가?
        if ( !IntStream.range(0, formula.length)
            .filter(NumberUtils::isOdd)
            .allMatch(i -> Operators.isOperator(formula[i])) )
            return false;

        return true;
    }
}
