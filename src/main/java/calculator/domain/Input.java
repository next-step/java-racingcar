package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private String userInput;
    private List<String> result = new ArrayList<String>();

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
        Validator.isEmpty(userInput);
    }

    public void parseInput() throws IllegalArgumentException {
        String input = userInput.replaceAll(" ", "");
        String temp = "";

        for (int i = 0; i < input.length(); i++) {
            char element = input.charAt(i);
            if (Character.isDigit(element)) {
                temp += element;
            } else if (element == '+' || element == '-' || element == '*' || element == '/') {
                result.add(temp);
                result.add(Character.toString(element));
                temp = "";
            } else {
                throw new IllegalArgumentException("숫자와 연산자, 공백문자만 입력할 수 있습니다.");
            }
        }
        if (temp.length() > 0) {
            result.add(temp);
        }
    }

    public List<String> getResult() {
        return result;
    }
}
