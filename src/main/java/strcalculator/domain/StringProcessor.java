package strcalculator.domain;

import java.util.Scanner;

public class StringProcessor {

    private String userInput;

    public StringProcessor() {
    }

    public void getInput() {
        Scanner sc = new Scanner(System.in);
        userInput = sc.nextLine();
    }

    public void checkInput() {
//        System.out.println("userInput: " + userInput);
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException("연산 가능한 수식을 입력해주세요.");
        }
    }

    public String[] test() {
        String[] split = userInput.split("[+]|-|/|[*]");
        for (String s : split) {
            System.out.println(s);
        }
        return split;
    }
}
