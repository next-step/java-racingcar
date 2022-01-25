package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementGenerator {

    private final String input;
    private final List<String> elements;

    public ElementGenerator(String input) {
        this.input = input;
        this.elements = new ArrayList<>();
        validateEmpty();
        createElements();
        validateCorrectOperator();
    }

    private void validateEmpty() {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Null이나 빈 공백 문자는 입력할 수 없습니다.");
        }
    }

    private void createElements() {
        elements.addAll(Arrays.asList(input.split(" ")));
    }

    private void validateCorrectOperator() {
        ArrayList<String> OPERATOR_CHAR = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));

        for (int i = 0; i < elements.size(); i++) {
            if (i % 2 == 1 && !OPERATOR_CHAR.contains(elements.get(i))) {
                throw new IllegalArgumentException("[ERROR] 사칙연산 기호만 입력하세요.");
            }
        }
    }

    public List<String> getElements() {
        return elements;
    }
}
