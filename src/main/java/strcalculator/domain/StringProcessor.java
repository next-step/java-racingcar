package strcalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringProcessor {

    private String userInput;
    private List<String> result = new ArrayList<String>();

    public StringProcessor(String userInput) {
        this.userInput = userInput;
        deleteSpaceString();
        checkInput();
    }

    private void checkInput() {
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException("연산 가능한 수식을 입력해주세요.");
        }
    }

    public void validation() {
        boolean matches = userInput.matches("[+\\-*/]|[0-9]+");
        if (matches == false) {
            throw new IllegalArgumentException("숫자와 연산자, 공백문자만 입력할 수 있습니다.");
        }

    }

    public String[] parseInputNumber() {
        String[] numbers = userInput.split("[+\\-*/]");
        return numbers;
    }

    public String[] parseInputOperands() {
        String[] operands = userInput.split("[0-9]+");
        return operands;
    }

    private void deleteSpaceString() {
        userInput = userInput.replaceAll(" ", "");

    }

}
