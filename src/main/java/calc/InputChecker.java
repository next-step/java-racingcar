package calc;

import java.util.Objects;
import java.util.regex.Pattern;

public class InputChecker {

    private static final String NULL_INPUT = "아무 것도 입력하지 않았습니다.";
    private static final String ILLEGAL_FORMULA = "입력한 식을 다시 한번 확인해주세요.";
    private static final String INPUT_DELIMETER = " ";
    private static final String INPUT_PATTERN = "^[\\d]+( [+|\\-|*|/] [\\d]+)*";
    private String[] formula;

    public InputChecker(String input) {
        this.formula = checkInput(input);
    }

    public String[] getFormula() {
        return formula;
    }

    private String[] checkInput(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(NULL_INPUT);
        }

        if (!isValidFormula(input)) {
            throw new IllegalArgumentException(ILLEGAL_FORMULA);
        }

        return input.split(INPUT_DELIMETER);
    }

    private boolean isValidFormula(String input) {
        return Pattern.matches(INPUT_PATTERN, input);
    }
}
