package stringcalculator.ui;

import stringcalculator.domain.Constant;
import stringcalculator.domain.Expression;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private final String inputValue;

    public InputView() {
        inputValue = scan();
        if (isEmpty(inputValue)) {
            throw new IllegalArgumentException(Constant.NOT_NULL);
        }
    }

    private String scan() {
        System.out.println("계산할 문자열을 입력하세요. 예) 2 + 3 * 4 / 2");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }

    private boolean isEmpty(String source) {
        return Objects.isNull(source) || Constant.NULL_STRING.equals(source.trim());
    }

    public Expression toExpression() {
        return new Expression(inputValue);
    }
}
