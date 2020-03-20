package step2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputCheck {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Double> numList = new ArrayList<>();
    ArrayList<String> operationList = new ArrayList<>();

    String numRegex = "[0-9]";
    String operationRegex = "[\\+\\-\\*\\/]";

    Pattern numPattern = Pattern.compile(numRegex);
    Pattern operationPattern = Pattern.compile(operationRegex);

    public void setInput() {
        System.out.println("사칙 연산할 문자열을 입력해주세요.");
        String input = scanner.nextLine();
        checkAndClassify(input);
    }

    public void checkAndClassify(String input){
        checkEmptyInput(input);
        classifyNumberAndOperation(input);
    }

    public void checkEmptyInput(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException();
        }
    }

    public void classifyNumberAndOperation(String input) {
        String[] strings = splitBlank(input);
        for (int i = 0; i < strings.length; i++) {
            addList(strings[i], i);
        }
    }

    private void addList(String param, int i) {
        if (i % 2 == 0) {
            checkNumber(param);
            numList.add(Double.parseDouble(param));
            return;
        }

        checkOperation(param);
        operationList.add(param);
    }

    public void checkNumber(String number) {
        if (!numPattern.matcher(number).matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public void checkOperation(String operation) {
        if (!operationPattern.matcher(operation).matches()) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    public String[] splitBlank(String input) {
        return input.split(" ");
    }

    public ArrayList<Double> getNumList() {
        return numList;
    }

    public ArrayList<String> getOperationList() {
        return operationList;
    }

}
