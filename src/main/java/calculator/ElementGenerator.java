package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementGenerator {

    private final String input;
    private String[] elements;

    public ElementGenerator(String input) {
        this.input = input;
        validateEmpty();
        createElements();
        validateCorrectOperator();
    }

    private void validateEmpty() {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] Null이나 빈 공백 문자는 입력할 수 없습니다.");
        }
    }

    private void createElements(){
        elements = input.split(" ");
    }

    private void validateCorrectOperator() {
        ArrayList<String> OPERATOR_CHAR = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        for(int i = 0; i < elements.length; i++) {
            if(i%2 == 1 && !OPERATOR_CHAR.contains(elements[i])) {
                throw new IllegalArgumentException("[ERROR] 사칙연산 기호만 입력하세요.");
            }
        }
    }

    public String[] getElements(){
        return elements;
    }
}
