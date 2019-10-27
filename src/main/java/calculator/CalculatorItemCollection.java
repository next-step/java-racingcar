package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.NumberUtils.isNotInteger;
import static calculator.OperatorType.isNotOperatorType;

public class CalculatorItemCollection {

    private static final String DELIMITER = " ";
    private static final int VALID_MINIMUM_SIZE = 3;

    private final List<String> item;

    public CalculatorItemCollection(String input) {

        if (input == null) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        this.item = parsingItem(input);
        validateItem();
    }

    public List<String> getItem() {
        return item;
    }

    private List<String> parsingItem(String input) {

        String[] split = input.split(DELIMITER);

        return Arrays.stream(split)
                .filter(this::isNotEmpty)
                .collect(Collectors.toList());
    }

    private boolean isNotEmpty(String a) {
        return !"".equals(a);
    }

    private void validateItem() {
        if (item.size() < VALID_MINIMUM_SIZE || isEven(item.size())) {
            throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");
        }

        for (int i = 0, size = item.size(); i < size; i++) {
            checkCharacter(i, item.get(i));
        }
    }

    private void checkCharacter(int i, String s) {
        if (isOdd(i)) {
            checkOperator(s);
            return;
        }

        checkNumeric(s);
    }

    private void checkNumeric(String s) {
        if (isNotInteger(s)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    private void checkOperator(String s) {
        if (isNotOperatorType(s)) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

}
