package calculator.domain;

import java.util.Scanner;

public class Calculator {
    private String input;
    public Calculator() {
        input = "";
    }

    public void StartCalculate() {
        input = GetUserInput();
    }

    private String GetUserInput() {
        Scanner scanner = new Scanner(System.in);
        String str;

        do {
            System.out.println("식을 입력하세요");
            str = scanner.nextLine();
        } while (!Validator.checkValidate(str));

        return str;
    }

}
