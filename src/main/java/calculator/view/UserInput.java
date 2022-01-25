package calculator.view;

import calculator.domain.Validator;
import java.util.Scanner;

public class UserInput {

    final private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        System.out.println("식을 입력하세요");

        String input = scanner.nextLine();

        if (!Validator.isValidExpression(input)) {
            System.out.println("[Error] 올바르지 못한 입력입니다.");
            return getInput();
        }

        return input;
    }
}