package strcalculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringProcessor {

    private String userInput;
    private List<String> result = new ArrayList<String>();

    public StringProcessor() {
    }
    public StringProcessor(String userInput){
        this.userInput=userInput;
    }

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
    }

    public void checkInput() {
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException("연산 가능한 수식을 입력해주세요.");
        }
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

    public boolean validation(){
        boolean matches = userInput.matches("[+\\-x/]|[0-9]+");
        System.out.println(userInput);
        return matches;
    }
    public List<String> getResult() {
        return result;
    }

    public String[] parseInputNumber(){
        String input = userInput.replaceAll(" ", "");
        String []numbers=input.split("[+\\-x/]");
        return numbers;
    }

    public String[] parseInputOperands(){
        String input = userInput.replaceAll(" ", "");
        String []operands=input.split("[0-9]+");
        return operands;
    }
}
