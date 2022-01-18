package calculator.domain;

import java.util.Scanner;

public class Calculator {
    private String input;
    public Calculator() {
        input = "";
    }

    public void StartCalculate() {
        System.out.println("식을 입력하세요");
        input = GetUserInput();
    }

    private String GetUserInput() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        while (!Validator.checkValidate(str)) {
            System.out.println("다시 입력하세요.");
            str = scanner.nextLine();
        }

        return str;
    }

}
